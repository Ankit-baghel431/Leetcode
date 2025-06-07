class Solution {
    public int tribonacci(int n) {
        if(n == 1 || n == 2){
            return 1;
        }
        if(n == 0){
            return 0;
        }
        int curr = 0;
        int pre1 = 0;
        int pre2 = 1;
        int pre3 = 1;
        for(int i = 2;i<n;i++){
            curr = pre1+pre2+pre3;
            pre1 = pre2;
            pre2 = pre3;
            pre3 = curr;
        }
        return curr;
    }
}