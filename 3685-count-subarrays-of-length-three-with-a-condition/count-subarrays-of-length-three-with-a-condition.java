class Solution {
    public int countSubarrays(int[] nums) {
        int l = 0;
        int r = 2;
        int count = 0;
        while(r<nums.length){
            if((double)(nums[l]+nums[r]) == (double)nums[l+1]/2){
                count++;
            }
            l++;
            r++;
        }
        return count;
    }
}