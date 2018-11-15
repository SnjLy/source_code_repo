#!/usr/bin/python
# coding: utf-8

'''
created on 2016.04.13
@author gaici
根据用户历史购买记录，进行猜你喜欢计算，并且推荐相关作品
'''

'''
计算距离，返回k个相似数据
'''
'''
数据列："select t1.user_id,t3.product_id,t3.zhima_price,t3.category,t2.artisan_level,t2.service_amount,t2.city,DATE_FORMAT(t1.create_time,'%Y%m%d')  
from us_order t1,artisan t2,artisan_product t3 where t1.product_id=t3.product_id and t1.artisan_id=t2.artisan_id and t1.status<>'20' and t1.pay_status=1 and t3.zhima_price>20"
'''

import sys

import mysql.connector
from numpy import *
from rediscluster import StrictRedisCluster


def classify0(inX, dataSet, labels, k):
    dataSetSize = dataSet.shape[0]
    diffMat = tile(inX, (dataSetSize, 1)) - dataSet
    sqDiffMat = diffMat ** 2
    sqDistances = sqDiffMat.sum(axis=1)
    distances = sqDistances ** 0.5
    sortedDistIndicies = distances.argsort()
    resLabels = []
    for i in range(k):
        resLabels.append(labels[sortedDistIndicies[i]])
    return resLabels


'''
进行最近作品数据格式化
'''


def formatRecentItems(userId, onum, totalPrice, favCategory, totalArtisanLevel, totalServiceAmount):
    cityId = 0
    cnn = mysql.connector.connect(user=sys.argv[4], password=sys.argv[5], host=sys.argv[2], port=sys.argv[3],
                                  database="yehao_test")
    cur = cnn.cursor()
    cur.execute("select artisan_id from us_order where user_id='%s' order by id desc limit 1" % (userId))
    alist = [i for i in cur]
    if len(alist) > 0:
        artisanId = alist[0][0]
        cur.execute("select city from artisan where artisan_id='%s'" % (artisanId))
        clist = [i for i in cur]
        if len(clist) > 0:
            cityId = clist[0][0]
    cur.close()
    cnn.close()
    resFormatList = []
    fr = open("new_items.txt")
    for line in fr.readlines():
        if "差价" in line or "卡" in line or "地推" in line:
            continue
        line = line.strip()
        listFromLine = line.split('\t')
        if listFromLine[6].strip() != str(cityId) and cityId != 0:
            continue
        if listFromLine[0] == "product_id":
            continue
        favNum = favCategory.get(listFromLine[2], 0)
        if favNum == 0:
            favNum = 1.0
        else:
            favNum = 1.0 / float(favNum)
        if listFromLine[2] == "tag_mei_rong":
            favNum = 0.0
        formatPrice = 0.0
        if listFromLine[1] == "NULL":
            formatPrice = 0.0
        else:
            formatPrice = listFromLine[1]
        resFormatList.append([formatPrice, favNum, listFromLine[3], listFromLine[4], listFromLine[0]])
    fr.close()
    return resFormatList


def list2matrix(resFormatList):
    classLabelVector = []
    numberOfLines = len(resFormatList)  # get the number of lines in the file
    returnMat = zeros((numberOfLines, 4))  # prepare matrix to return 
    index = 0
    for line in resFormatList:
        returnMat[index, :] = line[0:4]
        classLabelVector.append(line[-1])
        index += 1
    return returnMat, classLabelVector


'''
将数据的值归一到0-1区间处理
并且进行权重增减
'''


def autoNorm(dataSet):
    minVals = dataSet.min(0)
    maxVals = dataSet.max(0)
    ranges = maxVals - minVals
    normDataSet = zeros(shape(dataSet))
    m = dataSet.shape[0]
    normDataSet = dataSet - tile(minVals, (m, 1))
    normDataSet = normDataSet / tile(ranges, (m, 1))  # element wise divide
    x, y = normDataSet.shape
    normDataSet = normDataSet * tile([1, 10, 0, 0], (x, 1))  # #这是权重矩阵
    set_printoptions(threshold='nan')
    return normDataSet, ranges, maxVals, minVals


'''
(a,b,c,d)其中：
a=作品价格
b=作品类目
c=手艺人星级
d=手艺人接单次数
'''


def singleGuess(userId, onum, totalPrice, favCategory, totalArtisanLevel, totalServiceAmount):
    recentItemList = formatRecentItems(userId, onum, totalPrice, favCategory, totalArtisanLevel, totalServiceAmount)
    datingDataMat, datingLabels = list2matrix(recentItemList)
    normMat, ranges, maxVals, minVals = autoNorm(datingDataMat)
    if onum == 0:
        formatPrice = 0
        formatCategory = 0.0
        formatArtisanLevel = 0
        formatServiceAmount = 0
    else:
        formatPrice = (totalPrice / onum - minVals[0]) / (maxVals[0] - minVals[0])
        formatCategory = 0.0
        formatArtisanLevel = (totalArtisanLevel / onum - minVals[2]) / (maxVals[2] - minVals[2])
        formatServiceAmount = (totalServiceAmount / onum - minVals[3]) / (maxVals[3] - minVals[3])
    guessList = classify0((formatPrice, formatCategory, formatArtisanLevel, formatServiceAmount), normMat, datingLabels,
                          50)
    print "userId:" + userId
    # r = redis.StrictRedis(host=sys.argv[1], port=6379, db=0)
    # r.set('guess_u_like_' + userId, guessList)
    # r.set('guess_u_like_c67ac50c13484fa29d6ba8151a0a5aa5', guessList)
    startup_nodes = [{"host": sys.argv[1], "port": "6380"}]
    rc = StrictRedisCluster(startup_nodes=startup_nodes, decode_responses=True)
    rc.set('guess_u_like_' + userId, guessList)


def guess():
    import time
    print time.strftime("%Y/%m/%d %H:%M:%S start")

    fr = open("us_orders_order_by_user_id.txt")
    userId = ""
    totalPrice = 0.0
    favCategory = {}
    totalArtisanLevel = 0
    totalServiceAmount = 0
    onum = 0
    for line in fr.readlines():
        line = line.strip()
        listFromLine = line.split('\t')
        if (listFromLine[0] == "user_id"):  # 无效行跳过
            continue
        if listFromLine[0] != userId and userId != "":
            try:
                singleGuess(userId, onum, totalPrice, favCategory, totalArtisanLevel, totalServiceAmount)
            except:
                continue
            onum = 1
            userId = listFromLine[0]
            totalPrice = float(listFromLine[2])
            favCategory = {}
            favCategory[listFromLine[3]] = 1
            totalArtisanLevel = int(listFromLine[4])
            totalServiceAmount = int(listFromLine[5])
        else:
            userId = listFromLine[0]
            totalPrice = totalPrice + float(listFromLine[2])
            fnum = favCategory.get(listFromLine[3], 0)
            fnum = fnum + 1
            favCategory[listFromLine[3]] = fnum
            totalArtisanLevel = totalArtisanLevel + int(listFromLine[4])
            totalServiceAmount = totalServiceAmount + int(listFromLine[5])
            onum = onum + 1
    singleGuess(userId, onum, totalPrice, favCategory, totalArtisanLevel, totalServiceAmount)
    print time.strftime("%Y/%m/%d %H:%M:%S end")


def main():
    guess()


if __name__ == '__main__':
    main()
