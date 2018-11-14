# /usr/local/python
# coding=utf-8

"""
 # -*- coding: UTF-8 -*-
"""

import numpy as np
import pandas as pd
import matplotlib.pyplot as plt

s = pd.Series([1,3,5,np.nan,6,8])
print s

dates = pd.date_range('20180531', periods=7)
print dates
