from abc import ABC, abstractmethod


# ===============================
# 抽象类 (Abstraction)
# ===============================
class Animal(ABC):
    def __init__(self, name, age):
        self.__name = name  # 封装 (private 属性)
        self.__age = age

    # Getter / Setter (封装)
    def get_name(self):
        return self.__name

    def get_age(self):
        return self.__age

    def set_age(self, age):
        if age > 0:
            self.__age = age

    # 抽象方法，必须由子类实现
    @abstractmethod
    def make_sound(self):
        pass

    @abstractmethod
    def eat(self):
        pass


# ===============================
# 子类 (Inheritance + Polymorphism)
# ===============================
class Lion(Animal):
    def make_sound(self):  # 多态 (不同动物不同叫声)
        print(f"{self.get_name()} roars!")

    def eat(self):  # 多态
        print(f"{self.get_name()} eats meat.")


class Elephant(Animal):
    def make_sound(self):
        print(f"{self.get_name()} trumpets!")

    def eat(self):
        print(f"{self.get_name()} eats grass.")


class Monkey(Animal):
    def make_sound(self):
        print(f"{self.get_name()} chatters!")

    def eat(self):
        print(f"{self.get_name()} eats bananas.")


# ===============================
# 动物园类 (组合 + 封装)
# ===============================
class Zoo:
    def __init__(self, name):
        self.__name = name
        self.__animals = []  # 封装：不让外部直接操作

    def add_animal(self, animal: Animal):
        self.__animals.append(animal)

    def show_animals(self):
        print(f"Welcome to {self.__name} Zoo!")
        for a in self.__animals:
            a.make_sound()  # 多态：不同对象表现不同
            a.eat()
        print("=" * 30)


# ===============================
# 主程序
# ===============================
if __name__ == "__main__":
    zoo = Zoo("Happy Land")

    lion = Lion("Simba", 5)
    elephant = Elephant("Dumbo", 10)
    monkey = Monkey("George", 3)

    zoo.add_animal(lion)
    zoo.add_animal(elephant)
    zoo.add_animal(monkey)

    zoo.show_animals()
