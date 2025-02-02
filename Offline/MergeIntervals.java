class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) ->a[0] - b[0]);

        Stack<int []> st = new Stack<>();
        st.push(intervals[0]);

        for(int i = 1; i < intervals.length; i++){
            int [] interval = intervals[i];
            int st2 = interval[0];
            int en2 = interval[1];
            int st1 = st.peek()[0];
            int en1 = st.peek()[1];

            if(st2 <= en1){
                st.peek()[1] = Math.max(en1, en2);
            }else{
                st.push(interval);
            }
        }

        int [][] ans = new int[st.size()][2];

        for(int i = ans.length-1; i >= 0; i--){
            int [] interval = st.pop();
            ans[i] = interval;
        }
        return ans;
    }
}
