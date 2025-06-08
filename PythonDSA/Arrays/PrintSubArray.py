if __name__ == "__main__":
    li = [1, 2, 3, 4]
    n = len(li)
    for i in range(0, n):
        for j in range(i, n):
            for k in range(i, j + 1):
                print(li[k], end = " ")
            print()
