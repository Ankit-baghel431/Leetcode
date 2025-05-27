class Solution {
    int mod = 1000000007;
    int [][] dp;  
    public int numRollsToTarget(int n, int k, int target) {
        dp = new int[n + 1][target + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(n,k,target);
    }
    int helper(int n, int k, int target){
        if(n==0){
            return target == 0 ? 1 : 0;
        }
        if(target < 0) return 0;
        if(dp[n][target] != -1){
            return dp[n][target];
        } 
        int ways = 0;
        for(int i = 1;i<=k;i++){
            ways = (ways+helper(n-1,k,target-i))%mod;
        }
        return dp[n][target] = ways;
    }
}