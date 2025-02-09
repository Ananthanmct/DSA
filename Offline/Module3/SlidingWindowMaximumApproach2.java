class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int [] prefix = new int[nums.length];
        int [] suffix = new int[nums.length];
        prefix[0] = nums[0];
        for(int i = 1; i<nums.length; i++){
            if(i%k == 0){
                prefix[i] = nums[i];
            }else{
                prefix[i] = Math.max(prefix[i-1], nums[i]);
            }
        }
        suffix[suffix.length - 1] = nums[nums.length - 1];
        for(int i = nums.length - 2; i>=0; i--){
            if((i+1)%k == 0){
                suffix[i] = nums[i];
            }else{
                suffix[i] = Math.max(nums[i], suffix[i+1]);
            } 
        }
        int [] ans = new int[nums.length - k + 1];
        for(int i = 0; i<=nums.length-k; i++){
            if(i%k == 0){
                ans[i] = suffix[i];
            }else{
                ans[i] = Math.max(suffix[i], prefix[i+k-1]);
            }
        }
        return ans;
    }
}
