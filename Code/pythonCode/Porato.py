class Potato:
    price = 5

    def __init__(self, weight):
        self.weight = weight


obj1 = Potato(10)
obj1.price = 8
print(obj1.price)  # 8
print(Potato.price)  # 5
