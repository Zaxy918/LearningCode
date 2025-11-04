str = input()
dict = {}
for c in str:
    if c.isalpha():
        if c in dict:
            dict[c] += 1
        else:
            dict[c] = 1
for c in dict:
    print(f"{c}: {dict[c]}")
