class A:
    def __init__(self):
        print("111111")


class B:
    def __init__(self, x):
        self.x = x
        print("222222")


class C(A, B):
    pass


class D(A):
    pass


class A(D):
    pass


obj = C(2)
print(obj.x)
