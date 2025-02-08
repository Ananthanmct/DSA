def takeInput(n):
    arr = []
    i = 0
    while i < n:
        val = int(input("Enter value: "))
        arr.append(val)
        i = i + 1
    return arr


def subtract(arr1, arr2):
    if len(arr1) < len(arr2):
        arr1, arr2 = arr2, arr1  
    i = len(arr1) - 1
    j = len(arr2) - 1
    ans = [0] * len(arr1)  
    borrow = 0
    while i >= 0:
        val1 = arr1[i]
        val2 = arr2[j] if j >= 0 else 0  
        diff = val1 - val2 - borrow
        if diff < 0:
            diff += 10
            borrow = 1
        else:
            borrow = 0
        ans[i] = diff
        i -= 1
        j -= 1

    
    while len(ans) > 1 and ans[0] == 0:
        ans.pop(0)

    print("Array 1:", arr1)
    print("Array 2:", arr2)
    print("Subtraction Result:", ans)



n1 = int(input("Enter value for n1: "))
n2 = int(input("Enter value for n2: "))

arr1 = takeInput(n1)
arr2 = takeInput(n2)


subtract(arr1, arr2)