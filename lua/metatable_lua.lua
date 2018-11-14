#!/usr/local/bin/lua

--lua 元表体验

local set1={10,20,30}
local set2={20,40,50}

-- 将用于重载__add的函数，注意第一个参数是self
local union = function (self, another)
	-- body
	local set = {}
	local result = {}

	--利用数组来确保集合的互异性
	for i,j in pairs(self) do
		print(i, j)
		set[j]=true
	end

	for i,j in pairs(another) do
		print(i, j)
		set[j]=true
	end

	 -- 加入结果集合
    for i, j in pairs(set) do table.insert(result, i) end
    return result
end


setmetatable(set1, {__add = union})
local set3= set1 + set2
for i,v in pairs(set3) do
	io.write(i .. " " .. v .. )
end