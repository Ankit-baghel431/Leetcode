class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        String result = strs[0];
        int firlen = result.length();
        for(int i = 1;i<strs.length;i++){
            String s = strs[i];
            while(firlen > s.length() || !result.equals(s.substring(0,firlen))){
                firlen--;
                if(firlen == 0){
                    return "";
                }
                result = result.substring(0,firlen);
            }
        }
        return result;
        
    }
}