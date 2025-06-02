class Solution {
    public int solve(String text1, String text2, int i, int j , int [][]dp){
        if(i==text1.length()){
            return 0;
        }
        if(j==text2.length()){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        if(text1.charAt(i)==text2.charAt(j)){
            dp[i][j] = 1 + solve(text1, text2,i+1,j+1,dp);
        }
        else {
            dp[i][j] = Math.max(solve(text1, text2,i+1,j,dp),solve(text1, text2,i,j+1,dp));
        }
        return dp[i][j];
    }
    public int longestPalindromeSubseq(String s) {
        String revS = new StringBuilder(s).reverse().toString();
        int n = s.length();
        int[][] dp = new int[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                dp[i][j] = -1;
            }
        }
        return solve(s, revS, 0, 0, dp);
    }
}