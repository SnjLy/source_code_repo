#!/usr/local/bin/lua

a=5 --全局变量

function add(b)
	-- body
	local x = 1  --局部变量
	a = 12
	print("a=" .. a)
	print("x + b=" .. (x+b))
end

print(add(a));
print(a);
print(x);

local b = 10

x, y = 1,2
print("xy =" .. x .. y)
x,y=y,x
print("xy =" .. x .. y)


x,y,z="00", "01"  -- 不够的值设为nil
print(x,y,z)

x,y,z=1,2,3,4,5 -- 忽略多余的值
print(x,y,z)

--[[a, b = f()
f()返回两个值，第一个赋给a，第二个赋给b。

应该尽可能的使用局部变量，有两个好处：

1. 避免命名冲突。
2. 访问局部变量的速度比全局变量更快。]] --



