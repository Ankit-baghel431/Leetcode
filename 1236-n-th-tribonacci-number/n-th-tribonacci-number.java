class Solution {
    int[] dp;

    public int tribonacci(int n) {
        dp = new int[n + 1];
        Arrays.fill(dp, -1);

        if (n >= 0) dp[0] = 0;
        if (n >= 1) dp[1] = 1;
        if (n >= 2) dp[2] = 1;

        return helper(n);
    }

    int helper(int n) {
        if (dp[n] != -1) {
            return dp[n];
        }
        return dp[n] = helper(n - 1) + helper(n - 2) + helper(n - 3);
    }
}
