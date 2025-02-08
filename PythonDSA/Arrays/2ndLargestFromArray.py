def second_largest_element(arr):
    Smax = -10**9
    max = -10**9 #7
    i = 0
    while i < len(arr):
        if arr[i] > max:
            max = arr[i]
        i += 1

    i = 0 
    while i < len(arr):
        if arr[i] < max and arr[i] > Smax:
            Smax = arr[i]
        i +=1
    return Smax    
 
def second_approach(arr):
    max = Smax = -10**9
    i = 0
    while i < len(arr):
        if arr[i] > max:
            Smax = max
            max = arr[i]

        elif arr[i] > Smax:
            Smax = arr[i]
    
        i += 1

    return Smax

arr = [5,6,7,11,10,3]
result = second_approach(arr)
print(result)