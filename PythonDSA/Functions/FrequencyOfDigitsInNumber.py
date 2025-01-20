def frequency(n,d):
    count = 0
    while n != 0: 
        r = n%10 
        q = n//10 
        if r == d: 
            count = count + 1
        n = q 

    print(count)

cal = 1
while cal <= 10:
    n = int(input("Enter the value for n")) 
    d = int(input("Enter the value for d")) 
    frequency(n,d)   
    cal = cal + 1 