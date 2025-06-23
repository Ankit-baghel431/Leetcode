class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> map = new ArrayList<Integer>();
        int n = nums.length;
        for(int num : nums){
            map.add(num);
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 1;i<=n;i++){
            if(!map.contains(i)){
                list.add(i);
                map.remove(Integer.valueOf(i));
            }
            map.remove(Integer.valueOf(i));
        }
        return list;
    }
}