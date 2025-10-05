n = int(input())
cnt = 0
for i in range(1, n + 1):
    if int(i) % 7 == 0 or str(i).find("7") != -1:
        cnt += 1
print(cnt)
