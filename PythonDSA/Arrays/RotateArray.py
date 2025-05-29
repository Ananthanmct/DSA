class Solution:
    def reverse(self, arr, st, en):
        i = st
        j = en
        while i < j:
            temp = arr[i]
            arr[i] = arr[j]
            arr[j] = temp
            i += 1
            j -= 1
    def rotateArray(self, arr, k):
        n = len(arr)
        k = k%n
        if k < 0:
            k += n
        self.reverse(arr, 0, len(arr) - 1)
        self.reverse(arr, 0, k - 1)
        self.reverse(arr, k, len(arr) - 1)
      
if __name__ == "__main__":
    n = int(input())
    allNums = input().strip()
    arr = allNums.split(" ")
    nums = list(map(int, arr))
    k = int(input())
    obj = Solution()
    obj.rotateArray(nums, k)
    for num in nums:
        print(num, end = " ")
