import math
n = int(input("Enter a number: "))
for i in range(2, math.sqrt(n)):
    if n % i == 0:
        print(f"{n} is not a prime number.")
        exit(0)
print(f"{n} is a prime number.")