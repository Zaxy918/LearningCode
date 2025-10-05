def isPass(books):
    for book in books:
        if len(book) >= 10:
            print("warning")
            return
    print("pass")


n = int(input())
books = input().split()

isPass(books)
