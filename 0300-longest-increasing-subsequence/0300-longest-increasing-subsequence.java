class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int [][]dp = new int[n+1][n+1];
        for(int i = n-1;i>=0;i--){
            for(int j = i-1;j>=-1;j--){
                int notTake = 0+dp[i+1][j+1];
                int take = 0;
                if(j == -1 || nums[j]<nums[i]){
                    take = 1+dp[i+1][i+1];
                }
                dp[i][j+1] = Math.max(take,notTake);
            }
        }
        return dp[0][0];
    }
}