class Solution:    
    def reverseArray(self,arr1, n):
       ans = [0]*len(arr1) 
       i = len(arr1) - 1
       j = 0
       while j < len(arr1):
        ans[j] = arr[i]
        i -= 1
        j += 1
       return ans 
     

        
# def evenOrOdd(num):
#     num = int(num)
#     if num%2 == 0:
#         return 0
#     else:
#         return 1
if __name__=='__main__':
    n = int(input())
    allNums = input()
    inpArr = allNums.split(" ")
    arr = list(map(int, inpArr))
    obj = Solution()
    res = obj.reverseArray(arr, n)
    for i in range(0, len(res)):
        print(res[i], end = " ")
