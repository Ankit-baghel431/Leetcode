class Solution {
    public String longestPalindrome(String s) {
        if (s.length() <= 1)
            return s;
        int n = s.length();
        String lps = "";
        for (int i = 1; i < n; i++) {
            // odd palindrome
            int left = i;
            int right = i;
            while (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                if (left == -1 || right == n)
                    break;
            }
            String palindrome = s.substring(left + 1, right);
            if (palindrome.length() > lps.length()) {
                lps = palindrome;
            }
            // even palindrome
            left = i - 1;
            right = i;
            while (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                if (left == -1 || right == n)
                    break;
            }
            palindrome = s.substring(left + 1, right);
            if (palindrome.length() > lps.length()) {
                lps = palindrome;
            }
        }
        return lps;
    }
}