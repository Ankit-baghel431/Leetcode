class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        int maskL = 1<<n;
        List<List<Integer>> subset = new ArrayList<>();
        for(int i = 0;i<maskL;i++){
            List<Integer> list = new ArrayList<>();
            for(int j = 0;j<n;j++){
                if((i&(1<<j))!=0){
                    list.add(nums[j]);
                }
            }
            subset.add(list);
        }
        return subset;
    }
}