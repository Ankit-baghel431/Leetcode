class Solution {
    public int lengthOfLIS(int[] nums) {
        return solve(nums,0,-1);
    }
    int solve(int [] arr,int idx, int pre){
        if(idx == arr.length) return 0;
        int notTake = 0+solve(arr,idx+1,pre);
        int take = 0;
        if(pre == -1 || arr[pre] < arr[idx]){
            take = 1+solve(arr,idx+1,idx);
        }
        return Math.max(take,notTake);
    }
}