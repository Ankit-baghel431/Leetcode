class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        if (m == 0) return 0;
        if (m > n) return -1; 
        int p1 = 0;
        int p2 = 0;
        while(p1<n){
            if(haystack.charAt(p1) == needle.charAt(p2)){
                p1++;
                p2++;
                if(p2 == m){
                    return p1-m;
                }
            }
            else{
                p1 = p1 - p2 + 1;
                p2 = 0;
            }
            
        }
        return -1;
    }
}