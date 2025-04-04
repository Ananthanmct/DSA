class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
       int [] prefix = new int[arr.length];
       prefix[0] = arr[0];
       for(int i = 1; i < arr.length; i++){
            prefix[i] = prefix[i-1]^arr[i];
       }
       int [] ans = new int[queries.length];
       for(int i = 0; i < queries.length; i++){
            int leftIdx = queries[i][0];
            int rightIdx = queries[i][1];
            int leftPXor = leftIdx > 0 ? prefix[leftIdx - 1] : 0;
            int rightPXor = prefix[rightIdx];
            ans[i] = leftPXor^rightPXor;
       } 
       return ans;
    }
}
