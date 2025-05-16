class Solution {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        int[] dp = new int[n];
        int[] prev = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);

        List<List<String>> subsequences = new ArrayList<>();
        int maxLen = 1;

        for (int i = 0; i < n; i++) {
            int lenI = words[i].length();
            for (int j = 0; j < i; j++) {
                if (groups[i] != groups[j] &&
                        lenI == words[j].length() &&
                        hammingDistance(words[i], words[j]) == 1) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        prev[i] = j;
                    }
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        for (int i = 0; i < n; i++) {
            if (dp[i] == maxLen) {
                LinkedList<String> path = new LinkedList<>();
                int index = i;
                while (index != -1) {
                    path.addFirst(words[index]);
                    index = prev[index];
                }
                subsequences.add(path);
            }
        }

        return subsequences.isEmpty() ? new ArrayList<>() : subsequences.get(0);
    }

    private int hammingDistance(String s1, String s2) {
        int dist = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                dist++;
            }
        }
        return dist;
    }
}