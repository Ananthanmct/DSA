def decimal_to_binary(n):
        binary = ""

        while n != 0:
            r = n % 2
            binary = str(r) + binary  
            n = n // 2  
        print(f"The decimal representation of given binary is {binary}")    

cal = 1
while cal<=5:
       n = int(input("Enter the decimal value: "))
       decimal_to_binary(n)    
       cal = cal +1
