class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();
        getAllCom(candidates,0,target,ans,comb);
        return ans;

    }
    public void getAllCom(int[] candi,int idx, int target,List<List<Integer>> ans,List<Integer> comb){
        if(idx == candi.length || target < 0){
            return;
        }
        if(target == 0){
            ans.add(new ArrayList<>(comb));
            return;
        }
        comb.add(candi[idx]);
        getAllCom(candi,idx,target-candi[idx],ans,comb);
        comb.remove(comb.size()-1);
        getAllCom(candi,idx+1,target,ans,comb);
    }
}