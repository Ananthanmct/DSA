class Solution {
    public int[] calculateNge(int [] nums){
        Stack<Integer> st = new Stack<>();
        int [] nge = new int[nums.length];
        for(int i = nums.length - 1; i >= 0; i--){
            while(st.size() > 0 && nums[i] >= nums[st.peek()]){
                st.pop();
            }
            if(st.size() == 0){
                nge[i] = nums.length;
            }else{
                nge[i] = st.peek();
            }
            st.push(i);
        }
        return nge;
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int [] nge  = calculateNge(nums);
        int [] ans = new int[n - k + 1];

        for(int i  = 0; i <= n -k; i++){
            int j  = i;
            //System.out.println(i + " " + nge[j]);
            int eI = i + k - 1;
            while(nge[j] <= eI){
                //System.out.print(j + " , ");
                j = nge[j];
            }
            //System.out.println();
            ans[i] = nums[j];
        }
        return ans;
    }
}
