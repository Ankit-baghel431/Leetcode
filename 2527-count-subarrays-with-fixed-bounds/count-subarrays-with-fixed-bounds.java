class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;
        int minPosition = -1, maxPosition = -1, leftBound = -1;
        long count = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] < minK || nums[i] > maxK) {
                leftBound = i;
            }
            if (nums[i] == minK) {
                minPosition = i;
            }
            if (nums[i] == maxK) {
                maxPosition = i;
            }
            int validStart = Math.min(minPosition, maxPosition);
            if (validStart > leftBound) {
                count += (validStart - leftBound);
            }
        }
        return count;
    }
}