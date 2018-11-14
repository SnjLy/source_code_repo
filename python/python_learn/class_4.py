#!/usr/bin/python
# -*- coding: UTF-8 -*-

"""
 -*- coding: UTF-8 -*-
"""

import sys

sys.stdout.write(chr(1))
sys.stdout.write(chr(1))

print ''
for i in xrange(1, 11):
    for j in xrange(1, i):
        sys.stdout.write(chr(219))
        sys.stdout.write(chr(219))

    print ''
