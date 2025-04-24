class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int count = 0;
        for(int i = 0;i<n;i++){
            Set<Integer> curSet = new HashSet<>();
            for(int j = i;j<n;j++){
                curSet.add(nums[j]);
                if(curSet.size() == set.size()){
                    count += (n-j);
                    break;
                }
            }
        }
        return count;
    }
}