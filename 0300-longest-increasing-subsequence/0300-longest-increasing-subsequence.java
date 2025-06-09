class Solution {
    int [][] dp;
    public int lengthOfLIS(int[] nums){
        dp = new int[nums.length][nums.length+1];
        for(int []d : dp){
            Arrays.fill(d,-1);
        }
        return solve(nums,0,-1);
    }
    int solve(int [] arr,int idx, int pre){
        if(idx == arr.length) return 0;
        if(dp[idx][pre+1] != -1){
            return dp[idx][pre+1];
        }
        int notTake = 0+solve(arr,idx+1,pre);
        int take = 0;
        if(pre == -1 || arr[pre] < arr[idx]){
            take = 1+solve(arr,idx+1,idx);
        }
        return dp[idx][pre+1] = Math.max(take,notTake);
    }
}