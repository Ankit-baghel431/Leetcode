class Solution {
    public int deleteAndEarn(int[] nums) {
        int maxNum = 0;
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
        }

        int[] points = new int[maxNum + 1];
        for (int num : nums) {
            points[num] += num;
        }

        Integer[] memo = new Integer[maxNum + 1];
        return dp(maxNum, points, memo);
    }

    private int dp(int i, int[] points, Integer[] memo) {
        if (i == 0) return 0;
        if (i == 1) return points[1];
        if (memo[i] != null) return memo[i];

        int skip = dp(i - 1, points, memo);
        int take = points[i] + dp(i - 2, points, memo);

        return memo[i] = Math.max(skip, take);
    }
}
