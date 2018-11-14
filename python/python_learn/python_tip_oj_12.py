num2 = 0
num5 = 0

L = [2, 8, 3, 50]

for i in L:
    print i
    while i % 2 == 0:
        num2 += 1
        i = i / 2
for j in L:
    print j
    while j % 5 == 0:
        num5 += 1
        j = j / 5

if num2 >= num5:
    print 0
else:
    print 1
