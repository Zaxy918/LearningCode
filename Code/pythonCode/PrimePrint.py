for num in range(2, 101):
    is_prime = True

    # 优化：只需要检查到平方根
    for i in range(2, num):
        if num % i == 0:
            is_prime = False
            break

    if is_prime:
        print(num, end=" ")
