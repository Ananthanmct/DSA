class Solution {
    public int[] asteroidCollision(int[] arr) {
        Stack<Integer> st = new Stack<>();

        for(int i  = 0; i < arr.length; i++){
            if(arr[i] >= 0){
                st.push(arr[i]);
            }else{
                while(st.size() > 0 && st.peek() > 0 && Math.abs(arr[i]) > st.peek()){
                    st.pop();
                }
                if(st.size() > 0 &&  Math.abs(arr[i]) == st.peek()){
                    st.pop();
                }else if(st.size() > 0 && st.peek() > 0) {
                    continue;
                }else{
                    st.push(arr[i]);
                }
            }
        }


        int [] ans = new int[st.size()];
        int i = st.size() - 1;

        while(st.size() > 0){
            ans[i] = st.pop();
            i--;
        }

        return ans;





    }
}
