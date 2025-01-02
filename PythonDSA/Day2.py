n = int(input("Enter value for n: "))

# Approach 1

# sum = (n*(n+1))/2
# print(sum)

#Approach 2

sum = 0

#[1, n) -> [1, n+1)

for i in range(1, n + 1):
    sum = sum + i
    
print(sum)