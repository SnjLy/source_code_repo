#!/usr/local/python
# encoding=UTF-8
'''
斐波那契数列函数
'''


###定义函数计算斐波那契
def fib(max):
    n, a, b = 0, 0, 1
    while n < max:
        print b
        a, b = b, a + b
        n += 1
    return 'done'


print fib(6)

###将斐波那契数列函数改造成生成器
'''
最难理解的就是generator和函数的执行流程不一样。函数是顺序执行，遇到return语句或者最后一行函数语句就返回。
而变成generator的函数，在每次调用next()的时候执行，遇到yield语句返回，再次执行时从上次返回的yield语句处继续执行。
'''


def fibGenerator(max):
    n, a, b = 0, 0, 1
    while n < max:
        yield b  ##如果一个函数定义中包含yield关键字，那么这个函数就不再是一个普通函数，而是一个generator
        a, b = b, a + b
        n += 1


for x in fibGenerator(6):
    print x


###斐波那契数列generator
def triangles():
    L = [1]
    t = 0
    while t < 10:
        yield L
        k = 0
        l = len(L)
        L2 = []
        while k <= l:
            if k == 0:
                L2.insert(0, L[0]);
            elif k == l:
                L2.insert(k, L[l - 1])
            else:
                L2.insert(k, L[k] + L[k - 1])
            k += 1
        L = L2
        t += 1


def triangles2():
    L = [1]
    t = 0
    while t < 10:
        k = 0
        print L
        l = len(L)
        L2 = []
        while k <= l:
            if k == 0:
                L2.insert(0, L[0]);
            elif k == l:
                L2.insert(k, L[l - 1])
            else:
                L2.insert(k, L[k] + L[k - 1])
            k += 1
        L = L2
        t += 1
    return "done"


triangles2()
