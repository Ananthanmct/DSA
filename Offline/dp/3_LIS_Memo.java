class Solution {
    public int lengthOfLIS(int[] nums) {
        int [] dp = new int[nums.length];
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            int len = getMaxLenInSub(nums, i, dp);
            max = Math.max(max, len);
        }
        return max;
        
    }

    public int getMaxLenInSub(int [] num, int idx, int [] dp){ 
        // Iss function se expectation yeh ki jo bhi idx iske andar pass kara jayega 
        // Us index pe jo element hai uspe khtm hone wala maximum length increasing subsequence laa ke de de 
        // For example idx = 4 pe jo element 3 hai upe khtm hone wala maximum length increasing subsequce 2 length ka hai 
        // So yeh 2 return kar dega 
        if(dp[idx] != 0){
            return dp[idx];
        }
        int max = 0;
        for(int i = idx - 1; i >= 0; i--){
            if(num[i] < num[idx]){
                int len = getMaxLenInSub(num, i, dp);
                max = Math.max(max, len);
            }
        }
        dp[idx] = max + 1;
        return max + 1;
    }
}
