class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int temp = 0;
        for(int num : nums){
            if(num == 0){
                count = Math.max(temp,count);
                temp = 0;
            }else{
                temp++;
            }
        }
        return Math.max(count,temp);
    }
}