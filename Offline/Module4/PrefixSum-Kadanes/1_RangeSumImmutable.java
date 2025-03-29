class NumArray {
    int [] arr;
    int [] pSum;
    public NumArray(int[] nums) {
        this.arr = nums;
        this.pSum = new int[nums.length];
        pSum[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            pSum[i] = pSum[i - 1] + nums[i];
        }

    }
    
    public int sumRange(int left, int right) {
        // tc - > O(1)
        // int sum = 0;
        // for(int i = left; i <= right; i++){
        //     sum += arr[i];
        // }
        // return sum;
        // leftPSum -> 0 to left -1 
        int leftPSum =  left == 0 ? 0 : pSum[left -1];
        int rightPSum = pSum[right];
        return rightPSum - leftPSum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */