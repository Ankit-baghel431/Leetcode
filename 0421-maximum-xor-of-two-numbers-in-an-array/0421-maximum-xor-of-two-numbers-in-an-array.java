class Solution {
    static class TrieNode {
        TrieNode[] children = new TrieNode[2];
    }

    private void insert(TrieNode root, int num) {
        for (int i = 31; i >= 0; i--) {
            int bit = (num >>> i) & 1;
            if (root.children[bit] == null) {
                root.children[bit] = new TrieNode();
            }
            root = root.children[bit];
        }
    }

    private int findMaxXOR(TrieNode root, int num) {
        int maxXor = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >>> i) & 1;
            int toggled = 1 - bit;
            if (root.children[toggled] != null) {
                maxXor |= (1 << i);
                root = root.children[toggled];
            } else {
                root = root.children[bit];
            }
        }
        return maxXor;
    }

    public int findMaximumXOR(int[] nums) {
        TrieNode root = new TrieNode();
        int max = 0;

        for (int num : nums) {
            insert(root, num);
        }

        for (int num : nums) {
            max = Math.max(max, findMaxXOR(root, num));
        }

        return max;
    }
}