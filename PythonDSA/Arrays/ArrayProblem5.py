def take_input(n):
    arr=[]
    i = 0
    while i< n:
        val = int(input("Enter the value:"))
        arr.append(val)
        i +=1
    return arr 

def consecutive_number(arr,k):
    count = 0
    i = 0
    while i < len(arr)-1:
        if arr[i]+arr[i+1]==k:
            print((arr[i],arr[i+1]))
            count += 1
        i += 1
    return count    



n = int(input("Enter the value fo n:"))
k = int(input("Enter the value for K"))
arr = take_input(n)
result = consecutive_number(arr,k)
print(result)