if __name__ == "__main__":
    print(f"Entering in Program")
    n = int(input())
    print(f"Input taken for {n}")
    m = int(input())
    print(f"Input taken for {m}")
    mat = []
    for i in range(0, n):
        print(f"Value of i is {i}")
        mat.append([0]*m)
        print(mat)
    
    rows = len(mat)
    print(f"Value of row is {rows}")
    cols = len(mat[0])
    print(f"Value of col is {cols}")
    
    for row in range(0, rows):
        print(f"Entering in row {row}")
        for col in range(0, cols):
            print(f"Entering in col {col}")
            mat[row][col] = int(input())
        
    for row in range(0, rows):
        for col in range(0, cols):
            print(mat[row][col], end = " ")
        print()

  
    
    
