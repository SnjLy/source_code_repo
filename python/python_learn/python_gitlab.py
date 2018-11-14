#!/usr/local/python
# encoding=UTF-8

import requests

'''
读取配置的组名
'''
groupNames = ["card", "cs", "docs", "eoms", "family", "finance", "framework", "guide", "hlj-iris", "infra", "iris",
              "order", "pay", "pivot", "product", "promotion", "risk", "searching", "server", "studio", "trade", "user"]
'''
读取配置的用户名
'''
userNames = ["yehao", "xiaoma", "zhs08512", "daxiong", "xiaobi", "qiuyu", "chuanwu", "chonglou", "hezi", "pipixia",
             "canger", "kaixinguo", "dalong", "lanmao", "dafan", "wuweizi", "baiju", "xiaoniqiu"]

token = "wTxbxzx5uW_adnfHASTp"

userUrl = "https://git.hlj.team/api/v4/users?private_token=wTxbxzx5uW_adnfHASTp&username="
groupUrl = "https://git.hlj.team/api/v4/groups?private_token=wTxbxzx5uW_adnfHASTp&search="


def addMembers():
    for userName in userNames:
        url1 = userUrl + userName
        print "获取用户url", url1
        r = requests.get(url1).json()

        user_id = r[0].get('id')
        if user_id is None and user_id == '':
            print "用户不存在"
            continue
        for groupName in groupNames:
            groups = requests.get(groupUrl + groupName).json()
            if groups is None:
                print groupName, " group不存在"
            for g in groups:
                if groupName == g.get('full_name'):
                    group_id = g.get('id')

                    # 用户是否在这个组
                    url2 = "https://git.hlj.team/api/v4/groups/" + str(group_id) + "/members/" + str(
                        user_id) + "?private_token=wTxbxzx5uW_adnfHASTp"
                    # print url2
                    joined = requests.get(url2).json()
                    jId = joined.get('id')
                    ##pdb.set_trace()
                    if jId is not None:
                        print userName, " 已经存在", groupName

                    elif group_id is not None and user_id is not None:
                        print "准备添加", userName, "到group ", groupName
                        try:
                            res = requests.post("https://git.hlj.team/api/v4/groups/" + str(group_id) + "/members",
                                                data="private_token=wTxbxzx5uW_adnfHASTp&user_id=" + str(
                                                    user_id) + "&access_level=30")
                            print res
                            if res.status_code < 400:
                                print 'success'
                            else:
                                print 'fail'
                        except Exception as e:
                            print "添加用户组权限错误", e
                            raise e

    return 'done'


addMembers()
