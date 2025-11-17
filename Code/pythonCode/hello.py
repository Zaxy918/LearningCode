a = 1
b = 1.1
c = "Hello"
d = [1, 2, 3, 4]
e = {1, 2, 3, 4, 4}
f = {"A": 1, "B": 2}
g = (1, 2, 3)

# s = input()
# ans = ""
# set = set()
# for i in s:
#     if i in set:
#         continue
#     else:
#         ans = ans + i
#         set.add(i)
# print(ans)
# li = input().lower().split()
# dict = {}
# for i in li:
#     dict[i] = dict.get(i, 0) + 1
#     # if i in dict:
#     #     dict[i] += 1
#     # else:
#     #     dict[i] = 1
# print(dict)

# s = input().lower()
# m = ""
# for i in s:
#     if i.isalnum():
#         m = m + i
# l = m[::-1]
# if l == m:
#     print("True")

# s = input().split(" ")
# longest = max(s, key=len)
# print(longest, len(longest))

# li = input().split()
# s = ""
# for i in li[::-1]:
#     s += i + " "
# s = s[0:len(s) - 1]
# print(s)

for i in range(1, 10):
    for j in range(1, i + 1):
        print(f"{i}*{j}", end=" ")
    print()
