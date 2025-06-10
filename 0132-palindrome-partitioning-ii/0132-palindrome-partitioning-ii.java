class Solution {
    public int minCut(String s) {
        return solve(s, 0, new Integer[s.length()]) - 1;
    }

    private int solve(String s, int idx, Integer[] dp) {
        if (idx == s.length()) return 0;
        if (dp[idx] != null) return dp[idx];

        int minCuts = Integer.MAX_VALUE;

        for (int i = idx; i < s.length(); i++) {
            if (isPalindrome(s, idx, i)) {
                int cuts = 1 + solve(s, i + 1, dp);
                minCuts = Math.min(minCuts, cuts);
            }
        }
        return dp[idx] = minCuts;
    }

    private boolean isPalindrome(String str, int s, int e) {
        while (s < e) {
            if (str.charAt(s) != str.charAt(e))
                return false;
            s++;
            e--;
        }
        return true;
    }
}
