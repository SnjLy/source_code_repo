#!/usr/bin/python
# -*- coding:UTF-8-*-

 
from urllib import request
import json
from sys import argv
from numpy import *
from rediscluster import StrictRedisCluster
 

sendUrl =  "https://oapi.dingtalk.com/robot/send?access_token="
access_token = "9c4e21a4f3363d0a4e4a8e2057a9a20abc03769148e1c483ba2bb64bb6d2b70a"

shareNum = 2
meetingNum = 1
 
mobiles=[{"name":"", "mobile":"112123"},{"name":"", "mobile":""}]

"""
使用redis保存一周发送的人信息
{"share": [
    {
      "name": "yehao",  用户名
      "mobile":"12121"  mobile
      "type": 2         1 小分享  2 大分享
    }
  ]
}  
"""
redisKey = "customer_group_share_weekly_meeting_message"
 
def send_msg(mobile, content):
    """
     钉钉机器人API接口地址:
     https://open-doc.dingtalk.com/docs/doc.htm?spm=a219a.7629140.0.0.karFPe&treeId=257&articleId=105735&docType=1
     :param mobile:
     :param itemName:
     :return:
    """
    url = sendUrl + access_token
 
    data = {
        "msgtype": "text",
        "text": {
            "content": content
        },
        "at": {
            "atMobiles": [
                mobile
            ],
            "isAtAll": "true"
        }
    }
    # 设置编码格式
    json_data= json.dumps(data).encode(encoding='utf-8')
    print(json_data)
    header_encoding = {'User-Agent': 'Mozilla/5.0 (Windows NT 6.1; Trident/7.0; rv:11.0) like Gecko', "Content-Type": "application/json"}
    req = request.Request(url=url, data=json_data, headers=header_encoding)
    res = request.urlopen(req)
    res = res.read()
    print(res.decode(encoding='utf-8'))
 
def sendMeetingMsg():
	print "本周周会通知"
'''
	redis 存储消息 argv[1]=localhost:9376
	startup_nodes = [{"host": sys.argv[1], "port": "6380"}]
    rc = StrictRedisCluster(startup_nodes=startup_nodes, decode_responses=True)
    rc.set('redis_key_' + userId, guessList)
'''




def sendShareMsg():
	print "本周分享通知"

	pass


class MemberInfo(object):
	"""docstring for MemberInfo
		role 分享角色，1 小分享 2 大分享
	"""
	name = ""
	role = 1
	mobile =""

	def __init__(self, name, role, mobile):
		super(MemberInfo, self).__init__()
		self.name = name
		self.role = role
		self.mobile = mobile

		
 
if __name__ == "__main__":
    mobile = argv[1]
    content = argv[2]
    send_msg(mobile, content)






