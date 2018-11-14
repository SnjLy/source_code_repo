'''
格式化时间串
'''

t = {'year': '2013', 'month': '9', 'day': '30', 'hour': '16', 'minute': '45', 'second': '2'}
print '%s-%s-%s %s:%s:%s' % (
t.get('year'), t.get('month'), t.get('day'), t.get('hour'), t.get('minute'), t.get('second'))
print '%s-%s-%s %s:%s:%s' % (t['year'], t['month'], t['day'], t['hour'], t['minute'], t['second'])

print '%4d-%02d-%02d %02d:%02d:%02d' % (
int(t['year']), int(t['month']), int(t['day']), int(t['hour']), int(t['minute']), int(t['second']))
