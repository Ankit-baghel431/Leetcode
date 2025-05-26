class Solution {
    int [] dp;
    public int rob(int[] nums) {
        if (nums.length < 2){
            return nums[0];
        }
        dp = new int[nums.length+1];
        Arrays.fill(dp,-1);
        // dp[0] = nums[0];
        // dp[1] = Math.max(nums[0],nums[1]);
        // for(int i = 2;i<nums.length;i++){
        //     dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
        // }
        // return dp[dp.length-1];
        int n = nums.length;
        return helper(n-1,nums);
    }
    int helper(int n, int [] nums){
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        if(dp[n] != -1){
            return dp[n];
        }
        return dp[n] = Math.max(helper(n-1,nums),helper(n-2,nums)+nums[n]);
    }
}