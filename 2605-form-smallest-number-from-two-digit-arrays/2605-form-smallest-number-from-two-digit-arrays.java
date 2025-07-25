class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        int digit = Integer.MAX_VALUE;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    int newdigit = nums1[i];
                    digit = Math.min(digit, newdigit);
                } else {
                    if (nums1[i] < nums2[j]) {
                        int newdigit = nums1[i] * 10 + nums2[j];
                    } else {
                        int newdigit = nums2[j] * 10 + nums1[i];
                    }
                    digit = Math.min(digit, newdigit);
                }
            }
        }
        return digit;
    }
}