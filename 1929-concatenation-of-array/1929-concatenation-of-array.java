class Solution {
    public int[] getConcatenation(int[] nums) {
        int [] arr = new int[nums.length*2];
        int ind = 0;
        for(int num : nums){
            arr[ind++] = num;
        }
        for(int num : nums){
            arr[ind++] = num;
        }
        return arr;
    }
}