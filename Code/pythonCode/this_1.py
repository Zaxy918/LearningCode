def re(n):
    return str(n)[::-1]


print(re(1234))


def sw(w, t):
    return (t, w)


print(sw(3, 5))


def lis(list1: list, list2: list):
    return set(list1) | set(list2)


print(lis([1, 3, 2, 2], [1, 2, 4, 6]))


def cnt(s: str):
    dic = {}
    for i in s.split(","):
        if i in dic:
            dic[i] += 1
        else:
            dic[i] = 1
    return dic


print(cnt("apple,banana,apple,orange,banana,apple"))


def swapkv(dic: dict):
    return {v: k for k, v in dic.items()}


print(swapkv({'a': 1, 'b': 2, 'c': 3}))


def scorekv(stus: dict):
    avg = 0
    top = max(stus, key=stus.get)
    for v in stus.values():
        avg += v
    return avg / len(stus), top, {k: v for k, v in stus.items() if v >= 60}


print(scorekv({'Tom': 85, 'Lucy': 92, 'Lily': 76, 'Jack': 60}))


def cnt(alph: str):
    dic = {}
    ct = 0
    li = alph.split(" ")
    for item in li:
        if item in dic:
            ct += 1
        else:
            ct = 1
    dic = {item, ct}
    return dic


print(cnt("apple orange banana apple apple grape banana orange dog apple"))
