class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int totalsum = 0;
        for (int num : nums) {
            totalsum += num;
        }
        int leftsum = 0;
        for (int i = 0; i < n; i++) {
            if (leftsum == totalsum - leftsum - nums[i]) return i;
            leftsum += nums[i];
        }
        return -1;
    }
}