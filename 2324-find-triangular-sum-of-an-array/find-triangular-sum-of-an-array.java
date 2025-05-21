class Solution {
    public int triangularSum(int[] nums) {
        func(nums, 0, nums.length);
        return nums[0];
    }
    private void func(int[] nums, int st, int end){
        if(st == end) return;
        for(int i=1; i<end; i++){
            nums[i-1] = (nums[i]+nums[i-1])%10;
        }
        func(nums, st, end-1);
    }

}