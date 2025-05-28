class Solution {
    int row ;
    int col ;
    int dp[][];
    public int uniquePaths(int m, int n) {
        row = m;
        col = n;
        dp = new int[m][n];
        for(int []d : dp){
            Arrays.fill(d,-1);
        }
        return solve(0,0);
    }
    private int solve(int m , int n){
        if(m >= row || n >= col){
            return 0;
        }
        if(m+1 == row&& n+1 == col){
            return 1;
        }
        if(dp[m][n] != -1){
            return dp[m][n];
        }
        return dp[m][n] = solve(m+1,n)+solve(m,n+1);
        
    }
}