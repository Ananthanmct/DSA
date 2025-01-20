#Question1)
n = int(input("Enter the value:"))
r =1

while r<=n:
    l = chr(64+r)
    print(l*r)
    r = r +1

#Alternative method
n = int(input("Enter the value:"))
r =1

while r<=n:
    l = chr(64+r)
    
    count = r
    while count>=1:
        print(l, end="")
        count = count - 1
    print()

    r = r+1 
       

