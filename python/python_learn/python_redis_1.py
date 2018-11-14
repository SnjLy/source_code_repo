import sys
from rediscluster import StrictRedisCluster


"""
172.16.254.32:7000,172.16.254.32:7001,172.16.254.32:7002,172.16.254.32:7003,172.16.254.32:7004,172.16.254.32:7005
"""
startup_nodes = [{"host": '172.16.254.32', "port": "7000"},{"host": '172.16.254.32', "port": "7001"},{"host": '172.16.254.32', "port": "7002"},
				{"host": '172.16.254.32', "port": "7003"},{"host": '172.16.254.32', "port": "7004"},{"host": '172.16.254.32', "port": "7005"}]
rc = StrictRedisCluster(startup_nodes=startup_nodes, decode_responses=True)
rc.set('helijia_helijia_guess_u_like_' + "yehao", "yehao_list")

value=rc.get('helijia_helijia_guess_u_like_yehao')

print value