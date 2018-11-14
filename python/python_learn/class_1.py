#!/usr/bin/python 
# coding: UTF-8

"""
python对象，定义对象
对象的__init__构造方法
对象的析构函数：对象不再调用时销毁对象
对象的变量，方法 ：_foo: 以单下划线开头的表示的是 protected 类型的变量，即保护类型只能允许其本身与子类进行访问，不能用于 from module import *
				__foo: 双下划线的表示的是私有类型(private)的变量, 只能是允许这个类本身进行访问了。

"""

'''
所有员工的基类
'''


class Employee:
    empCount = 0

    def __init__(self, name, salary):
        self.name = name
        self.salary = salary
        Employee.empCount += 1

    def __del__(self):
        class_name = self.__class__.__name__
        print class_name, "调用析构函数，销毁对象"

    def displayCount(self):
        print "Total Employee %d" % Employee.empCount

    def displayEmployee(self):
        print "Name : ", self.name, ", Salary: ", self.salary
        print "Employee.__doc__:", Employee.__doc__
        print "Employee.__name__:", Employee.__name__
        print "Employee.__module__:", Employee.__module__
        print "Employee.__bases__:", Employee.__bases__
        print "Employee.__dict__:", Employee.__dict__


def testClass(name, salary):
    e = Employee(name, salary)
    e.displayCount()
    e.displayEmployee()
    del e


if __name__ == '__main__':
    # pdb.set_trace()
    testClass("yehao", "9999999")
