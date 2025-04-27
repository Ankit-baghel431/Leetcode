class Solution {
    public boolean checkValidString(String s) {
        int minRange=0,maxRange=0;
        for(char c:s.toCharArray()){
            if(c=='(') {
                minRange++;
                maxRange++;
            }
            else if(c==')') {
                if(minRange>0) minRange--;
                maxRange--;
            }
            else {
                if(minRange>0) minRange--;
                maxRange++;
            }
            if(maxRange<0) return false;
        }
        return minRange==0;
    }
}