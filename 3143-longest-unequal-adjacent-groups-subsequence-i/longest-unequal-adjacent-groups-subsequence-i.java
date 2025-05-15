class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> list = new ArrayList<>();
        if(words == null || words.length == 0){
            return list;
        }
        list.add(words[0]);
        int preval = groups[0];
        for(int i = 1;i<groups.length;i++){
            if(groups[i] != preval){
                list.add(words[i]);
                preval = groups[i];
            }
        } 
        return list;
    }
}