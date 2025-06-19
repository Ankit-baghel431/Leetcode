class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closesum = nums[0]+nums[1]+nums[2];
        for(int i=0;i<nums.length-2;i++){
            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                int currentsum = nums[i]+nums[left]+nums[right];
                if(Math.abs(currentsum-target) < Math.abs(closesum-target)){
                    closesum = currentsum;
                }
                if(currentsum < target){
                    left++;
                } else if(currentsum > target){
                    right--;
                }else{
                    return currentsum;
                }
            }
        }
        return closesum;
    }
}