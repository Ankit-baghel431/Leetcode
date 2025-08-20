class Solution {
    public void moveZeroes(int[] nums) {
        int lnzi = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[lnzi] = nums[i];
                lnzi++;
            }
        }
        for(int i = lnzi;i<nums.length;i++){
            nums[i]=0;
        }
    }
}