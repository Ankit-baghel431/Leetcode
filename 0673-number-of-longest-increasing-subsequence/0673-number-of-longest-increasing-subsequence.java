class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp, 1);
        int count[] = new int[n];
        Arrays.fill(count, 1);
        int maxL = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    // dp[i] = Math.max(dp[i],dp[j]+1);
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if (dp[i] == dp[j] + 1) {
                        count[i] += count[j];
                    }
                }
                maxL = Math.max(maxL, dp[i]);
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == maxL) {
                ans += count[i];
            }
        }
        return ans;
    }
}