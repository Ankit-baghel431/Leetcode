class Solution {
    public List<Integer> partitionLabels(String s) {
        int [] lastIndex = new int[26];
        List<Integer> list = new ArrayList();
        for(int i = 0;i<s.length();i++){
            lastIndex[s.charAt(i)-'a'] = i;
        }
        int start = 0;
        int end = 0;
        for(int i = 0;i<s.length();i++){
            end = Math.max(end,lastIndex[s.charAt(i)-'a']);
            if(end == i){
                list.add(end-start+1);
                start = i+1;
            }
        }
        return list;
    }
}