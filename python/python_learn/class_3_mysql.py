#!/usr/bin/python
# conding:UTF-8

import MySQLdb


def connectDB():
    connect = MySQLdb.connect(host="localhost", user="root", passwd="123456", db="skylab",
                              port=3306)
    cursor = connect.cursor()
    sql = "SELECT * FROM application"
    cursor.execute(sql)

    rows = cursor.fetchall()

    for row in rows:
        print row
        pass


connectDB()


class Application(object):
    """docstring for Application"""
    name = "init"

    def __init__(self):
        name = self.__class__
