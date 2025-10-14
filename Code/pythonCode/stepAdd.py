def stadd(n):
    if n == 1:
        return 1
    else:
        mult = 1
        for i in range(1, n + 1):
            mult *= i
        return mult + stadd(n - 1)


print(stadd(eval(input())))
