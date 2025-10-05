day = int(input())
n, m = map(int, input().split())
time = n * m + 12 * 60
day = (day + (time // (24 * 60))) % 7
hour = (time // 60) % 24
minute = time % 60
print("%d,%02d:%02d" % (day, hour, minute))
