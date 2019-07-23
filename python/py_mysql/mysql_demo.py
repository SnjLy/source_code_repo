#!/usr/local/bin/python
# -*- coding: UTF-8 -*-

import sys 
print(sys.version)

import MySQLdb;
# 打开数据库连接
db = MySQLdb.connect('106.13.44.20', 'root', 'yehao123456', 'yehao', 6066, charset='utf8')
# 使用cursor()方法获取操作游标
cursor = db.cursor()
try:
        # 使用execute方法执行SQL语句
        cursor.execute('SELECT VERSION()')
        # 使用 fetchone() 方法获取一条数据
        data = cursor.fetchone()
        print("Database version : %s " % data)

        sql = "select * from city"
        cursor.execute(sql)
        cities = cursor.fetchall()
        for row in cities:
            print("id=%d, cityCode=%s" % (row[0], row[1]))
except:
   print("Error: unable to fetch data")
# 关闭数据库连接db.close()
db.close()
