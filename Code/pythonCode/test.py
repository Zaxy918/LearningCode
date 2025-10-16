class obj:
    def __init__(self, n):
        self.n = n

    # overriding __eq__ method
    def __eq__(self, other):
        return self.n == other.n

    # overriding __hash__ method
    def __hash__(self):
        return hash(self.n)


o1 = obj(1)
o2 = obj(1)
o3 = obj(1)
o4 = o1
# initializing a set with objects
s = {o1, o2, o3, o4}
print(len(s))
