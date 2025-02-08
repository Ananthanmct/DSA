def take_input(n):
    li = []
    i = 0
    while i < n:
        number = int(input("Enter the value: "))
        li.append(number)
        i = i + 1
    return li

def max_element(arr):
    size = len(arr)
    i = 1
    max_value = arr[0]
    while i < size:
        if arr[i] > max_value:
            max_value = arr[i]
        i += 1
    return max_value

def buildings(arr):
    max_height = max_element(arr)
    current_height = max_height
    while current_height >= 1:
        i = 0
        while i < len(arr):
            if arr[i] >= current_height:
                print("*\t", end="")
            else:
                print("\t", end="")
            i += 1
        print()  
        current_height -= 1  


n = int(input("Enter the value for n: "))
arr = take_input(n)
max_val = max_element(arr)
print("Array:", arr)
print("Maximum height:", max_val)
print("Building representation:")
buildings(arr) 