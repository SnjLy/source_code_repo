#!/usr/bin/python
# coding:UTF-8

"""
class_2
类继承

方法重写与重载
运算符重载
"""


class Parent(object):
    """define a parent class for extends"""
    name = ""

    def __init__(self, name):
        self.name = name

    def printAttr(self):
        print "name:", self.name


class Child(Parent):
    """docstring for child"""
    age = 18

    def __init__(self, age, name):
        self.age = age
        self.name = name


p = Parent("jone")
p.printAttr()
c = Child(20, "trigger")
print "child name:", p.name + c.name, "chile age:", c.age
c.printAttr()
