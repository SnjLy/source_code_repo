# !/usr/bin/python
# encoding: utf-8  

import time

import numpy as np
from numpy import linalg as la


def calEuclideanDistance(vec1, vec2):
    euclidean = la.norm(vec1 - vec2)
    print "欧式距离:", euclidean
    dist = 1.0 / (1.0 + euclidean)
    print "相似度:", dist
    return dist


v1 = np.arange(4)
v2 = np.arange(4) - 2

if __name__ == '__main__':
    print time.strftime(" caclculate : %Y/%m/%d %H:%M:%S start")
    calEuclideanDistance(v1, v2)
    calEuclideanDistance(v1, v1)
