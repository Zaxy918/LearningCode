n = 5
for i in range(n + 1):
    # 打印空格
    for j in range(n - i):
        print(" ", end="")
    # 打印星号
    for j in range(i + 1):
        print("*", end="")
    print()
