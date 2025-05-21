class Solution {
    public int triangularSum(int[] nums) {
        if (nums.length == 1) return nums[0];

        int[] newArr = new int[nums.length - 1];
        for (int j = 0; j < nums.length - 1; j++) {
            newArr[j] = (nums[j] + nums[j + 1]) % 10;
        }
        return triangularSum(newArr);
    }
}