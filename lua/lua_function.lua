#!/usr/local/bin/lua
print("\n\nlearn lua function .......")

function function1(n)
	-- body
	print(n)
	if n == 0 then
		return 1
	else
		return n*function1(n-1) 
	end
end

print(function1(5));
factorial1=function1
print(factorial1(5));


function fun(param, anFun)
	-- body
	if param == 1 then 
		anFun(1)
	else 
		anFun(0)
	end
end

function  anFun(num)
	-- body
	if num == 0 then 
		print(0)
	else 
		print(1)
	end
end

print(fun(2, anFun));
print(fun(1, function ( x )
	-- body
	print("参数的平方" .. x*x)
end));