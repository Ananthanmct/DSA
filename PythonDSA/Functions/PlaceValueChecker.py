def isZeroPresentAtSecondPosition(n):
    placeValue = 0
    while n != 0:
        placeValue = placeValue + 1
        rem = n%10
        que = n//10
        if placeValue == 2 and rem == 0:
            return True
        n = que
    return False
        
        


isZeroPresentAtSecondPosition(25501)
