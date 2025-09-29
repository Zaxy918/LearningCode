sum = 0
for i in range(1, 101):
    sum += pow(-1, i - 1) * 1 / i
print(sum)
