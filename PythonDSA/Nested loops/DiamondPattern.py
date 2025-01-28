n = int(input("Enter value for n:" ))

spaces = n//2
stars = 1
row = 1

while row <= n:
    
    starCount = stars
    spaceCount = spaces
    
    while spaceCount >= 1:
        print(" ",end = " ")
        spaceCount = spaceCount - 1
        
    while starCount >= 1:
        print("*", end = " ")
        starCount = starCount - 1
    
    print()
    
    if row <= n//2:
         spaces = spaces - 1
         stars = stars + 2
    else:
         spaces = spaces + 1
         stars = stars - 2
    
   
    row = row + 1
    
