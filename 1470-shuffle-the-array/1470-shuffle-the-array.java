class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] arr = new int[nums.length];
        int x = 0;
        int y = 1;
        for (int i = 0; i < nums.length; i++) {
            if (x < nums.length) {
                arr[x] = nums[i];
            }
            if (y < nums.length) {
                arr[y] = nums[i + n];
            }
            x += 2;
            y += 2;
        }
        return arr;
    }
}