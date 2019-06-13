#!/usr/bin/python
# -*- coding: UTF-8 -*-

# 题目：一个数如果恰好等于它的因子之和，这个数就称为"完数"。例如6=1＋2＋3.编程找出1000以内的所有完数。 

from sys import stdout

for i in range(2, 1001):
    j=i  # j用于记录减去因子之后的值
    k=[] # 定义数组用于记录他的因子
    n=-1 # 用于数字计数
    for t in range(1,i):
        if i% t ==0:  # t是I的因子
            n+=1  
            j-=t
            k.append(t)
    
    if j == 0: # 减去因子后为0
        print(i)
        for s in range(0, n):
            stdout.write(str(k[s]))
            stdout.write(' ')
        print(k[n])

