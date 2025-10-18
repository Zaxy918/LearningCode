import sys


def build_matrix(n: int) -> list[list[int]]:
	return [[i * n + j + 1 for j in range(n)] for i in range(n)]


def rotate_submatrix(matrix: list[list[int]], x: int, y: int, r: int, clockwise: bool) -> None:
	size = 2 * r + 1
	top = x - r - 1
	left = y - r - 1
	sub = [row[left : left + size] for row in matrix[top : top + size]]
	if clockwise:
		rotated = [[sub[size - 1 - j][i] for j in range(size)] for i in range(size)]
	else:
		rotated = [[sub[j][size - 1 - i] for j in range(size)] for i in range(size)]
	for i in range(size):
		matrix[top + i][left : left + size] = rotated[i]


def main() -> None:
	data = sys.stdin.read().strip().split()
	if not data:
		return
	numbers = list(map(int, data))
	it = iter(numbers)
	try:
		n = next(it)
		m = next(it)
	except StopIteration:
		return
	matrix = build_matrix(n)
	for _ in range(m):
		try:
			x = next(it)
			y = next(it)
			r = next(it)
			z = next(it)
		except StopIteration:
			break
		rotate_submatrix(matrix, x, y, r, z == 0)
	for row in matrix:
		print(" ".join(map(str, row)))


if __name__ == "__main__":
	main()
