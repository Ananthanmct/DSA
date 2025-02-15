arr = [[0]*5]*3

# Approach 1

# rowIdx = 0 
# rows = len(arr)

# while rowIdx < rows: # 0 < 4
#     arr1D = arr[rowIdx] # [8, 9, 10, 21, 55]
#     colIdx = 0
#     while colIdx < len(arr1D): # 0 < 5
#         print(arr1D[colIdx], end=" ")
#         colIdx += 1
#     print()
#     rowIdx += 1



# Approach2 

i = 0 # represents rows index 
n = len(arr) # reprsents totalNumner of rows 

while i < n:
    m = len(arr[i])
    j = 0
    while j < m:
        arr[i][j] = int(input(f"Enter value for {i} and {j} "))
        j = j + 1
    i = i + 1

i = 0

while i < n:
    m = len(arr[i])
    j = 0
    while j < m:
       print(arr[i][j], end=" ")
       j = j + 1
    print()
    i = i + 1