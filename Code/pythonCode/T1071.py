dates = list()
while True:
    cur = input()
    if cur == "N":
        break
    dates.append(int(cur))
print(max(dates))
