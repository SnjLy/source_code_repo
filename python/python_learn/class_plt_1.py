# /usr/local/python
# coding=UTF-8

import matplotlib.pyplot as plt
import numpy as np

plt.figure(1)
ax = plt.subplot(111)
x = np.linspace(0, np.pi * 2, 200)  # 在0到2pi之间，均匀产生200点的数组

# r = 2cosθ
r = 2 * np.cos(x)  # 半径
ax.plot(r * np.cos(x), r * np.sin(x))

# r = 1
r = 1
ax.plot(r * np.cos(x), r * np.sin(x))

plt.show()
