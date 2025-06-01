class Solution {
    int [][] dp ;
    public int coinChange(int[] coins, int amount) {
        dp = new int[coins.length][amount+1];
        for (int[] row : dp) Arrays.fill(row, -1);
        int result = solve(coins, 0, amount);
        return result == Integer.MAX_VALUE ? -1 : result;
    }
    int solve(int[] coins, int idx , int amount){
        if(amount == 0){
            return 0;
        }
        if(amount < 0 || idx >= coins.length){
            return Integer.MAX_VALUE;
        }
        if(dp[idx][amount] != -1){
            return dp[idx][amount];
        }
        int take = solve(coins, idx, amount - coins[idx]);
        if (take != Integer.MAX_VALUE) take += 1;
        int notTake = solve(coins, idx + 1, amount);
        return dp[idx][amount] = Math.min(take,notTake);
    }
}