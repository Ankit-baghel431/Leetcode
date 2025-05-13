class Solution {
    public int partitionString(String s) {
        int[] lastSeen = new int[26];
        Arrays.fill(lastSeen, -1);

        int count = 0;
        int substringStart = 0;

        for (int i = 0; i < s.length(); i++) {
            int chIndex = s.charAt(i) - 'a';

            if (lastSeen[chIndex] >= substringStart) {
                count++;
                substringStart = i;
            }

            lastSeen[chIndex] = i;
        }

        return count + 1;
    }
}