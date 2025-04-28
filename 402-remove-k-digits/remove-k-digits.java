class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length() == k){
            return "0";
        }
        Stack<Character> s = new Stack<>();
        for(int i = 0;i<num.length();i++){
            char c = num.charAt(i);
            while (!s.isEmpty() && k > 0 && s.peek() > c) {
                s.pop();
                k--;
            }
            s.push(c);
        }
        while (k > 0) {
            s.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        for (char digit : s) {
            sb.append(digit);
        }
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}