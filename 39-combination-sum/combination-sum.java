class Solution {
    public void getallcombination(int[] candidates,int idx,List<List<Integer>> ans,List<Integer> combi, int target){
        if(idx == candidates.length || target < 0){
            return ;
        }
        if(target == 0){
            ans.add(new ArrayList<>(combi));
            return;
        }
        combi.add(candidates[idx]);
        getallcombination(candidates,idx,ans,combi,target-candidates[idx]);
        combi.remove(combi.size()-1);
        getallcombination(candidates,idx+1,ans,combi,target);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combi = new ArrayList<>();
        getallcombination(candidates,0,ans,combi,target);
        return ans;
    }
}