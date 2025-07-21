class Solution {
    public String makeFancyString(String s) {
        StringBuilder result = new StringBuilder();
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                count = 1;
            }
            if (count <= 2) {
                result.append(s.charAt(i));
            }
        }
        return s.isEmpty() ? "" : s.charAt(0) + result.toString();
    }
}