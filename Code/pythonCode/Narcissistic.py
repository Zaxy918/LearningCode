# for i in range(100, 1000):
#     hundred = i // 100
#     ten = (i // 10) % 10
#     one = i % 10
#     if hundred * hundred * hundred + ten * ten * ten + one * one * one == i:
#         print(i, end=" ")
for a in range(1, 10):
    for b in range(0, 10):
        for c in range(0, 10):
            if a * a * a + b * b * b + c * c * c == a * 100 + b * 10 + c:
                print(a * 100 + b * 10 + c, end=" ")
