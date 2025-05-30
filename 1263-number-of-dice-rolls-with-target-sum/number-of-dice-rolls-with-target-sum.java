class Solution {
    int mod = 1000000007;
    public int numRollsToTarget(int n, int k, int target) {
        int [][] dp = new int[n+1][target+1];
        dp[0][0] = 1;
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=target;j++){
                for(int z = 1;z<=k;z++){
                    if(j-z >= 0){
                        dp[i][j] = (dp[i][j] + dp[i-1][j-z])%mod;
                    }
                }
            }
        }
        return dp[n][target];
    }
}