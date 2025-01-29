def take_input_in_list(n):
    i = 0
    while i < n:
        element = int(input("Enter value: "))
        li.append(element)
        i += 1
    return li

def sum_of_array(arr):
    size = len(arr)
    i = 0
    total_sum = 0
    while i < size:
        total_sum += arr[i]
        i += 1
    return total_sum


def floor_of_average(arr):
    total_sum = sum_of_array(arr)  
    size = len(arr)
    return total_sum // size  


def max_element(arr):
    size = len(arr)
    i = 1
    max_val = arr[0]  
    
    while i < size:
        if arr[i] > max_val:
            max_val = arr[i]
        i += 1
    return max_val


n = int(input("Enter value for n: "))
li = []
arr = take_input_in_list(n)


total_sum = sum_of_array(arr)
floor_avg = floor_of_average(arr)  
max_val = max_element(arr)


print(f"Sum of elements: {total_sum}")
print(f"Floor of Average: {floor_avg}")
print(f"Maximum Element: {max_val}")