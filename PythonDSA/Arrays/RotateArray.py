def reverse(arr,  st, en):
    i = st;
    j = en;
    
    while i < j:
        temp = arr[i]
        arr[i] = arr[j]
        arr[j] = temp
        i += 1
        j -= 1
        




arr = [2, 3, 4, 1]
k = -1



n = len(arr)
k= k%n
if k < 0:
    k = k +  n
reverse(arr, 0, n - 1)
reverse(arr, n - k, n - 1)
reverse(arr, 0, n - k - 1)
print(arr)
