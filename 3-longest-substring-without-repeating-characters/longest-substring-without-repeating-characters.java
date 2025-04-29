class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int n = s.length();
        int i = 0, j = 0;
        int maxlength = 0;
        while (j < n) {
            char ch = s.charAt(j);
            if (!set.contains(ch)) {
                set.add(ch);
                maxlength = Math.max(maxlength, j - i + 1);
                j++;
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return maxlength;
    }
}