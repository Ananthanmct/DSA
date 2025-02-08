def takeInput(n):
    arr = []
    i = 0
    while i < n:
        val = int(input("Enter value"))
        arr.append(val)
        i = i + 1
    return arr
    
        
def add(arr1, arr2):
    i = len(arr1) - 1
    j = len(arr2) - 1
    n3 = max(len(arr1), len(arr2)) + 1
    ans = [0]*n3
    k = len(ans) - 1
    carry = 0
    while i >= 0 or j >= 0 :
        val1 = 0
        if i >= 0:
            val1 = arr1[i]
        val2 = 0
        if j >= 0:
            val2 = arr2[j]
        s = val1 + val2 + carry  
        carry = s//10
        ans[k] = s%10
        i -= 1
        k -= 1
        j -= 1
    if carry == 1:
        ans[0] = 1

    print(arr1)
    print(arr2)
    print(ans)
    


n1 = int(input("Enter value for n1 "))
n2 = int(input("Enter value for n2 "))

arr1 = takeInput(n1)
arr2 = takeInput(n2)
add(arr1, arr2)