class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<String, Integer> map = new HashMap<>();
        int count = 0;

        for (int[] domino : dominoes) {
            int a = domino[0];
            int b = domino[1];
            String key = a < b ? a + "," + b : b + "," + a;
            int val = map.getOrDefault(key, 0);
            count += val;
            map.put(key, val + 1);
        }
        return count;
    }
}