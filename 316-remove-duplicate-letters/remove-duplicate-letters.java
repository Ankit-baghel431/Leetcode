class Solution {
    public String removeDuplicateLetters(String s) {
        int[] freq = new int[26];
        boolean[] inStack = new boolean[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            int index = ch - 'a';
            freq[index]--;
            if (inStack[index]) continue;
            while (!stack.isEmpty() && ch < stack.peek() && freq[stack.peek() - 'a'] > 0) {
                inStack[stack.pop() - 'a'] = false;
            }
            stack.push(ch);
            inStack[index] = true;
        }
        StringBuilder result = new StringBuilder();
        for (char ch : stack) {
            result.append(ch);
        }
        return result.reverse().toString();
    }
}