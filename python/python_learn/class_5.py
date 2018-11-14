#!/usr/local/python
# encoding=UTF-8
"""
# -*- coding: utf-8 -*-
列表生成式使用
"""

L1 = ['Hello', 'World', 18, 'Apple', None]
L2 = []
for s in L1:
    if isinstance(s, str):
        L2.append(s.lower())

print L2
if L2 == ['hello', 'world', 'apple']:
    print '测试通过!'
else:
    print '测试失败!'

# 列表生成式

T1 = [x * x for x in range(10)]
print T1
# [0, 1, 4, 9, 16, 25, 36, 49, 64, 81]

# 只要把一个列表生成式的[]改成()，就创建了一个生成器
T2 = (x * x for x in range(10))
print T2
# <generator object <genexpr> at 0x1022ef630>

for n in T2:
    print n
