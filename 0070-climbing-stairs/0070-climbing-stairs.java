class Solution {
    public int climbStairs(int n) {
        if(n<=1) return n;
        int curr = 0;
        int pre1 = 1;
        int pre2 = 1;
        for(int i = 1;i<n;i++){
            curr = pre1+pre2;
            pre2 = pre1;
            pre1 = curr;
        }
        return curr;
    }
}