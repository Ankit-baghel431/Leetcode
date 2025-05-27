class Solution {
    public int differenceOfSums(int n, int m) {
        int res = 0;
        int ans = 0;
        for(int i = 1;i<=n;i++){
            if(i%m == 0){
                ans+=i;
            }else{
                res+=i;
            }
        }
        return res-ans;
    }
}