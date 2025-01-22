def isZero(num):
    div = 1
    while num != 0:
        rem = num%10;
        q = num//10;
        if div == 2:
            if rem == 0:
                return True
            else:
                return False
        num = q
        div = div + 1
    return False


t = int(input("Enter number of testcases"))
count = 1
while count <= t:
    inNum = int(input(f"Enter the value for testcase {count}"))
    res = isZero(inNum)
    if res == True:
        print(f"for testcase {count} zero exists")
    else:
        print(f"for testcase {count} zero does not exist")
    count = count + 1
