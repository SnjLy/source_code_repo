#!/usr/bin/python
# -*- coding:UTF-8 -*-


fileName=open("artisan_district_sql.sql", "w")

sql = 'INSERT INTO artisan_district(artisan_id,latitude, longitude, address) values()'
for i in range(0, 10):
    try:
#       print s
        fileName.write(sql + "\n")
    except:
        print "写入文件错误"
        fileName.close()

    

if not fileName.closed:
    fileName.close()
print "写入文件结束sql"