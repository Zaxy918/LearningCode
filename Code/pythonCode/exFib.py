# 写一个用数组实现的斐波那契的非递归版本
def fibonacci(n):
    fib = [0, 1]
    for i in range(2, n + 1):
        fib.append(fib[i - 1] + fib[i - 2])
    return fib[n]


print(fibonacci(10))  # 示例调用，返回第10个斐波那契数


def fibo(n):
    if n == 0:
        return 0
    if n == 1:
        return 1
    return fibo(n - 1) + fibo(n - 2)


print(fibo(2))


# 写一个汉诺塔递归程序
def hanoi(n, s, t, a):
    if n == 1:
        print(f"Move disk 1 from {s} to {t}")
        return
    hanoi(n - 1, s, a, t)
    print(f"Move disk {n} from {s} to {t}")
    hanoi(n - 1, a, t, s)


hanoi(4, "A", "C", "B")  # 示例调用，移动4个盘子从A到C，B作为辅助柱


# 写一个递归走迷宫程序
def dfs(maze, x, y, path):
    if x < 0 or x >= len(maze) or y < 0 or y >= len(maze[0]) or maze[x][y] != 0:
        return False
    path.append((x, y))
    if (x, y) == (len(maze) - 1, len(maze[0]) - 1):
        return True
    maze[x][y] = -1  # 标记为已访问
    if (
        dfs(maze, x + 1, y, path)
        or dfs(maze, x - 1, y, path)
        or dfs(maze, x, y + 1, path)
        or dfs(maze, x, y - 1, path)
    ):
        return True
    maze[x][y] = 0  # 恢复状态
    path.pop()
    return False


maze = [
    [0, 1, 0, 0, 0],
    [0, 1, 0, 1, 0],
    [0, 0, 0, 1, 0],
    [0, 1, 1, 1, 0],
    [0, 0, 0, 0, 0],
]
