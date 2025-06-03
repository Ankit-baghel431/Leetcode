class Solution {
    public int minDistance(String word1, String word2, int m, int n, int [][] dp){
        if(m < 0) return n+1;

        if(n < 0) return m+1;

        if (dp[m][n] != -1) return dp[m][n];

        if (word1.charAt(m) == word2.charAt(n)) {
            return dp[m][n] = minDistance(word1, word2, m - 1, n - 1, dp);
        }

        int insert = minDistance(word1, word2,m,n-1,dp);
        int delete = minDistance(word1, word2,m-1,n,dp);
        int replace = minDistance(word1, word2,m-1,n-1,dp);
        
        return dp[m][n] = 1+ Math.min(insert, Math.min(delete,replace));


    }
    public int minDistance(String word1, String word2){
        int m = word1.length();
        int n = word2.length();
        int [][] dp = new int[m+1][n+1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return minDistance(word1,word2,m-1,n-1,dp);
    }
}