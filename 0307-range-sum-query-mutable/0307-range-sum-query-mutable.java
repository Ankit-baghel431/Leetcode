class NumArray {
    private int[] nums; 
    private int [] BIT;
    int Range_sum(int i){
        int res = 0;
        i++;
        while (i>0) {
            res += BIT[i];
            i = i-(i&(-i));
        }
        return res;
    }
    void updateBIT(int i, int x){
        i++;
        while(i<BIT.length){
            BIT[i] = BIT[i]+x;
            i = i+(i&(-i));
        }
    }
    public NumArray(int[] nums) {
        this.nums = new int[nums.length];
        this.BIT = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            update(i, nums[i]);
        }
    }
    public void update(int index, int val){
        int diff = val - nums[index];
        nums[index] = val;
        updateBIT(index, diff);
    }
    public int sumRange(int left, int right) {
        return Range_sum(right)-Range_sum(left-1);
    }
}
/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */