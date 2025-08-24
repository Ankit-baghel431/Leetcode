class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int [] temp = new int[n];
        int j = 0;
        for(int i = n-k;i<n;i++){
            temp[j] = nums[i];
            j++;
        }
        for(int i = 0;i<n-k;i++){
            temp[j] = nums[i];
            j++;
        }
        for(int i = 0;i<n;i++){
            nums[i] = temp[i];
        }
    }
}