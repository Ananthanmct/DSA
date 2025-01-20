n = int(input("Enter the value:"))
count = 1
a = 0
b = 1

while count <= n:
    print(a, end="  ")
    c = a+b
    a = b
    b = c
    count = count + 1
print()    