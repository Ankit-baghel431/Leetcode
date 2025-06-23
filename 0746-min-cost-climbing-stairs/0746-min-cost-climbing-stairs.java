class Solution {
    int dp[];
     int mincost(int [] cost , int n){
        if(n<0){
            return 0;
        }
        if(n==0||n==1){
            return cost[n];
        }
        if(dp[n] != -1){
            return dp[n];
        }
        return dp[n] = cost[n]+ Math.min(mincost(cost,n-1),mincost(cost,n-2));
    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        return Math.min(mincost(cost, n-1),mincost(cost,n-2));
    }
}