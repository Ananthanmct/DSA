class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int [] ans = new int[n];
        int size = 0;
        for(int i = 0; i < n; i++){
            int lo = 0;
            int hi = size;
            
            while(lo < hi){
                int mid = lo + (hi - lo)/2;
                if(ans[mid] >= nums[i]){
                    hi = mid;
                }else{
                    lo = mid +  1;
                }
            }

            ans[lo] = nums[i];
            if(lo == size){
                size++;
            }
        }

        return size;
    }

}
