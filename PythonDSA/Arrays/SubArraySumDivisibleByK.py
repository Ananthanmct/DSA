def showAllSubarray(arr, k):
    i = 0
    count = 0
    while i < len(arr):
        j = i
        while j < len(arr):
            st = i
            en = j 
            x = st
            sum = 0
            while x <= en:
                print(arr[x], end = " ")
                sum += arr[x]
                x += 1
            print()
            if sum%k == 0:
                count += 1
            j = j + 1
        i = i + 1
        
    print(count)



# [1, 2]
# [3]
# [2, 3, 4]
# [4, 5]
# [6]
arr = [1, 2, 3, 4, 5,6]
showAllSubarray(arr, 3)
