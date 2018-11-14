#!/usr/local/bin/lua

print("hello world");
print "hello";

print(type("hello"));
print(type(1));
print(type(10.3*3));
print(type(type));
print(type(true));
print(type(nil));


table={key1="val1", key2="val2", "val3"}
for k,v in pairs(table) do
	print(k .."--" .. v)
end

table.key1 = nil
for k,v in pairs(table) do
	print(k,v)
end


--[[> type(x)
nil
> type(x) == nil
false
> type(x) == "nil"
true--]]

--[[字符串]]--
print("\n\nlearn lua string ........")
str=[[www.baidu.com]]
print(str);
print(#str)



print("\n\nlearn lua table .......")
tab = {}
tab["key"]="hello";
key=10
tab[key]=10
tab[key]=tab[key] + 11
for k,v in pairs(tab) do
	print(k .. "--" .. v)
end
a1={}
print(a1);
print(#a1);
print(a1[1]);







