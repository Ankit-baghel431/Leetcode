class Solution {
    private int solve(int[] jd, int idx, int n, int d,int [][] dp) {
        if (d == 1) {
            int maxD = jd[idx];
            for (int i = idx; i < n; i++) {
                maxD = Math.max(maxD, jd[i]);
            }
            return maxD;
        }
        if (dp[idx][d] != -1) {
            return dp[idx][d];
        }
        int maxD = jd[idx];
        int result = Integer.MAX_VALUE;
        for (int i = idx; i <= n - d; i++) {
            maxD = Math.max(maxD, jd[i]);
            int tempresult = maxD + solve(jd, i + 1, n, d - 1,dp);
            result = Math.min(result, tempresult);
        }
        return dp[idx][d] = result;
    }

    public int minDifficulty(int[] jd, int d) {
        int n = jd.length;
        if (n < d)
            return -1;
        int[][] dp = new int[n+1][d+1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(jd, 0, n, d,dp);
    }
}