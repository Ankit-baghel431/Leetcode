class Solution {
    public char findTheDifference(String s, String t) {
        int n = s.length();
        int m = t.length();
        boolean[] used = new boolean[s.length()];
        for (int i = 0; i < m; i++) {
            char tc = t.charAt(i);
            boolean found = false;
            for (int j = 0; j < n; j++) {
                if (!used[j] && s.charAt(j) == tc) {
                    used[j] = true;
                    found = true;
                    break;
                }
            }
            if (!found) {
                return tc;
            }
        }
        return ' ';
    }
}