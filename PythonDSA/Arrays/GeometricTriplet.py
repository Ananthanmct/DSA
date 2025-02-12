def Geometric_Triplets(arr):
    n = len(arr)
    triplets = []
    i = 0
    while i < n - 2:
        j = i + 1
        while j < n - 1:
            k = j + 1
            while k < n:
                if arr[j] * arr[j] == arr[i] * arr[k]:
                    ratio = arr[j]/arr[i]
                    triplets.append((arr[i], arr[j], arr[k], {"ratio":ratio}))
                k += 1  
            j += 1
        i += 1
    return triplets



arr = [2,8,10,15,16,30,32,64]
result = Geometric_Triplets(arr)
print(result)


























arr = [2,8,10,15,16,30,32,64]