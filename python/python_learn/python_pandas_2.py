import pandas as pd
import numpy as np
# coding=utf-8

df = pd.read_csv("/Users/yehao/Desktop/userId.csv", header=0, encoding='ISO-8859-1')
# print data
index = df.index
columns = df.columns
print index, columns
# ixs = df._ixs()
# print ixs
columns1 = df.head(5)

print columns1
