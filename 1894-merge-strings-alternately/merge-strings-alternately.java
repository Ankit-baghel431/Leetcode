class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder newWord = new StringBuilder();
        int n = word1.length();
        int m = word2.length();
        int idx = 0;
        if(n>m) idx = n;
        else idx = m;
        for(int i = 0;i<idx;i++){
            if(i<n){
                newWord.append(word1.charAt(i));
            }
            if(i<m){
                newWord.append(word2.charAt(i));
            }
        }
        return newWord.toString();
    }
}