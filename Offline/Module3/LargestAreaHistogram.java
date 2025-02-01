class Solution {
    public int [] nsl(int [] hieghts){
        Stack<Integer> st = new Stack<>();
        int [] ans = new int[hieghts.length];
        for(int i = 0; i < hieghts.length; i++){
            while(st.size() > 0 && hieghts[i] <= hieghts[st.peek()]){
                st.pop();
            }
            if(st.size() == 0){
                ans[i] = -1;
            }else{
                ans[i] = st.peek();
            }
            st.push(i);
        }
        return ans;
    }

    public int[] nsr(int [] hieghts){
        Stack<Integer> st = new Stack<>();
        int [] ans = new int[hieghts.length];
        for(int i = hieghts.length - 1; i >= 0; i--){
            while(st.size() > 0 && hieghts[i] <= hieghts[st.peek()]){
                st.pop();
            }
            if(st.size() == 0){
                ans[i] = hieghts.length;
            }else{
                ans[i] = st.peek();
            }
            st.push(i);
        }
        return ans;
    }
    public int largestRectangleArea(int[] heights) {
        int [] nslArr = nsl(heights);
        int [] nsrArr = nsr(heights);
        int maxArea = Integer.MIN_VALUE;
        for(int i = 0; i < heights.length; i++){
            int area = heights[i]*(nsrArr[i] -nslArr[i] - 1);
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;

    }
}
