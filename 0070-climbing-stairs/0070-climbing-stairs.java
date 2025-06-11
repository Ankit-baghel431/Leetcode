class Solution {
    int []dp;
    public int climbStairs(int n) {
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n);
    }
    int solve(int n){
        if(n<=1) return 1;
        if(dp[n]!=-1){
            return dp[n];
        }
        int ways = solve(n-2)+solve(n-1);
        return dp[n] = ways;
    }
}