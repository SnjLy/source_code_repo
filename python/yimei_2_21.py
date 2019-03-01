# /usr/local/python
# -*- coding: utf-8 -*-

import sys
import time

import xlrd

reload(sys)
sys.setdefaultencoding('utf-8')

city = {"北京": "110100", "天津": "120100", "上海": "310100", "南京": "320100", "武汉": "420100", "杭州": "330100", "广州": "440100",
        "深圳": "440300", "重庆": "500100", "成都": "510100", "西安": "610100"}

sql = "insert into `yehao_test`.`choice_city_resource` (`city_code`, `flag_type`, `create_time`, `object_id`, `resource_type`) values "
workbook = xlrd.open_workbook("/Users/yehao/Yehao/需求文档/首页为你甄选/yimei.xlsx")

worksheet1 = workbook.sheet_by_index(0)
nrows = worksheet1.nrows
ncols = worksheet1.ncols
print worksheet1.name, nrows, ncols

for curr in xrange(1, nrows):
    rows = worksheet1.row_values(curr)
    if rows:
        code = city.get(str(rows[0]))

        if code:
            # pdb.set_trace()
            if curr == nrows - 1:
                val = "".join("('" + str(code) + "','1','" + str(
                    time.strftime("%Y-%m-%d %H:%M:%S", time.localtime())) + "','" + str(rows[2]) + "','" + str(
                    int(rows[3])) + "');")
            else:
                val = "".join("('" + str(code) + "','1','" + str(
                    time.strftime("%Y-%m-%d %H:%M:%S", time.localtime())) + "','" + str(rows[2]) + "','" + str(
                    int(rows[3])) + "'),")

        if val.strip() != "":
            print val
            sql = sql + val

print sql
