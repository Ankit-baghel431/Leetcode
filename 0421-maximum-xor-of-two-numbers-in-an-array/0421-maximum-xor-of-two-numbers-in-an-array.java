class Solution {
    public int findMaximumXOR(int[] nums) {
        int max = 0;
        for(var num: nums)
            max = Math.max(max, num);
        if(max == 0) return 0;
        
        int mask = 0x40000000;
        while((mask & max) == 0) mask >>= 1;

        int ret = 0;
        int masks = 0;
        while(mask != 0) {
            masks |= mask;
            if(check(nums, masks, ret | mask))
                ret |= mask;
            mask >>= 1;
        }
        return ret;
    }

    private boolean check(int[] nums, int masks, int ans) {
        Set<Integer> vis = HashSet.newHashSet(nums.length);
        for(int num : nums) {
            num &= masks;
            if(vis.contains(num ^ ans)) return true;
            vis.add(num);
        }
        return false;
    }
}