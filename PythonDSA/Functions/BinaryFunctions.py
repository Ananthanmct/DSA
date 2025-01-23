#11100
#43210     


#0*2^0+0*2^1+1*2^2+1*2^3+1*2^4
#0+0+4+8+16

# Decimal representation of binary number using while loop
n = int(input("Enter the binary value: "))  
m = 0  
power = 0  

while n != 0:
    r = n % 10  
    m = m + (r * (2 ** power))  
    power = power + 1  
    n = n // 10  

print(f"The decimal representation for given binary number is {m}")

#Binary to decimal using functions

def binary_to_decimal(n):
      m = 0  
      power = 0  

      while n != 0:
        r = n % 10  
        m = m + (r * (2 ** power))  
        power = power + 1  
        n = n // 10
      print(f"The decimal representation for given binary number is {m}")  

cal = 1
while cal <= 5:
    n = int(input("Enter the binary value: ")) 
    binary_to_decimal(n)
    cal = cal + 1      


