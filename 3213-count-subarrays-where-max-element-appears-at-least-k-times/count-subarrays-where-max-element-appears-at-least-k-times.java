class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int maxVal = Integer.MIN_VALUE;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }

        long count = 0;
        int left = 0, maxFreq = 0;
        for (int right = 0; right < n; right++) {
            if (nums[right] == maxVal) {
                maxFreq++;
            }
            while (maxFreq >= k) {
                count += n - right;
                if (nums[left] == maxVal) {
                    maxFreq--;
                }
                left++;
            }
        }
        return count;
    }
}