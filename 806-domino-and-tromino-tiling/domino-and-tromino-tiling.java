class Solution {
    private static final int MOD = 1_000_000_007;
    public int numTilings(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;

        long[] dp = new long[n + 1];
        long[] preSum = new long[n + 1];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        preSum[0] = 1;
        preSum[1] = 2;
        preSum[2] = 4;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + 2 * preSum[i - 3]) % MOD;
            preSum[i] = (preSum[i - 1] + dp[i]) % MOD;
        }

        return (int) dp[n];
    }
}