import sys
from rediscluster import StrictRedisCluster


"""
172.16.117.7:7000,172.16.117.7:7001,172.16.117.7:7002,172.16.117.7:7003,172.16.117.7:7004,172.16.117.7:7005
"""
startup_nodes = [{"host": '172.16.117.7', "port": "7000"},{"host": '172.16.117.7', "port": "7001"},{"host": '172.16.117.7', "port": "7002"},
				{"host": '172.16.117.7', "port": "7003"},{"host": '172.16.117.7', "port": "7004"},{"host": '172.16.117.7', "port": "7005"}]
rc = StrictRedisCluster(startup_nodes=startup_nodes, decode_responses=True)
rc.set('guess_u_like_' + "yehao", "yehao_list")

value=rc.get('guess_u_like_yehao')

print value