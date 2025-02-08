def reverse_array(arr):
    i = 0
    j = len(arr) - 1
    while i<= j:
        temp = arr[i]
        arr[i] = arr[j]
        arr[j] = temp
        i +=1
        j -=1


arr = [2,3,4,5,6,7]        
reverse_array(arr)
print(arr)