name = "mama"
print(name.capitalize())
print(name.upper())
print(name.startswith("m"))
names = "Tom Jack Alice"
print(name.find("a", 2, 4))  # Find substring
print(name.count("a"))
print(name.replace("m", "b", 1))  # Replace substring
chars = names.split(" ")  # Split string
print(chars)
# List operations
my_list = [1, "hello", 3, 4, 5]
for i in my_list:
    print("We are visiting %s" % i)
print(my_list[0])
print(my_list[1:4])
print(my_list[:3])
print(my_list[2:])
print(my_list[::2])  # Every second element
print(my_list[::-1])  # Reverse the list
my_list.append(6)  # Add element to the end
my_list.remove(3)  # Remove first occurrence of 3
my_list.pop()  # Remove last element
my_list.insert(2, 10)  # Insert 10 at index 2
print(my_list)
print(2 in my_list)
# Tuple operations
my_tuple = (1, 2, 3)
for i in my_tuple:
    print(i)
print(my_tuple[1])
# Dictionary operations
my_dict = {"a": 1, "b": 2}
peoples = {"Alice": 25, "Bob": 30}
print(my_dict["a"])
print(peoples["Alice"])
peoples["Charlie"] = 35  # Add new key-value pair
peoples["Alice"] += 26  # Update value
if True:
    print("yes")


def is_even(n):
    return n % 2 == 0


def factorial(n):
    if n == 0:
        return 1
    if n <= 20:
        mult = 1
        for i in range(1, n + 1):
            mult *= i
        return mult
    return -1


print(factorial(4))


def power(a, b):
    if b < 0:
        return 1 / power(a, -b)
    if b == 0:
        return 1
    return a * power(a, b - 1)
