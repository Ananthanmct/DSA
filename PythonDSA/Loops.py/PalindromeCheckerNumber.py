n = int(input("Enter the number:"))
original = n
rev = ""

while n!=0:
    r = n%10
    q = n//10
    rev = rev + str(r)
    n = q


if rev==str(original):
    print(True)
else:
    print(False)       
