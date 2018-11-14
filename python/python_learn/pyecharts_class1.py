#!/usr/local/python
# encoding=UTF-8
import sys

from pyecharts import *

reload(sys)

sys.setdefaultencoding('utf8')

'''
##URL:参考文档：http://pyecharts.org/#/zh-cn/prepare
'''

# 柱状图
bar = Bar("我的第一个图表", "标题是这个")
bar.add("服装", ["衬衫", "羊毛衫", "雪纺衫", "裤子", "高跟鞋", "袜子"], [5, 20, 36, 10, 75, 90])
# 打印配置项
# bar.show_config()
bar.render()

attr = ['周一', '周二', '周三', '周四', '周五', '周六', '周日', ]
line = Line("折线图示例")
line.add("最高气温", attr, [11, 11, 15, 13, 12, 13, 10],
         mark_point=["max", "min"], mark_line=["average"])
line.add("最低气温", attr, [1, -2, 2, 5, 3, 2, 0],
         mark_point=["max", "min"], mark_line=["average"],
         yaxis_formatter="度")
# line.show_config()
line.render()
