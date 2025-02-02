class Solution {
    public int trap(int[] height) {
        Stack<Integer> st = new Stack<>();
        int waterLogged = 0;
        for(int i  = 0; i < height.length; i++){
            while(st.size() > 0 && height[i] > height[st.peek()]){
                int midIdx = st.pop();
                if(st.size() == 0){
                    break;
                }
                int left = height[st.peek()];
                int right = height[i];
                int finalHeight = Math.min(left, right) - height[midIdx];
                waterLogged += finalHeight*(i - st.peek() -1);
            }
            st.push(i);
        }
        return waterLogged;
    }
}
