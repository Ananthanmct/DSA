class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        return lcs(text1, text2, 0, 0, new Integer[text1.length()][text2.length()]);
    }

    public int lcs(String text1, String text2, int i, int j, Integer [][] dp){
        if(i == text1.length() || j == text2.length()){
            return 0;
        }
        if(dp[i][j] != null){
            return dp[i][j];
        }
        char ch1 = text1.charAt(i);
        char ch2 = text2.charAt(j);
        if(ch1 == ch2){
            int len = lcs(text1, text2, i + 1, j + 1, dp) + 1;
            dp[i][j] = len;
        }else{
            int len1 = lcs(text1, text2, i, j + 1, dp);
            int len2 = lcs(text1, text2, i + 1, j, dp);
            dp[i][j] = Math.max(len1, len2);
        }
        return dp[i][j];
    }
}
