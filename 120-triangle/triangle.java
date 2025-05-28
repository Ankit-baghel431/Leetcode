class Solution {
    private int [][] dp ;
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        dp = new int[n][n];
        for(int d[]:dp){
            Arrays.fill(d,-1);
        }
        return solve(triangle, 0, 0);
    }
    private int solve(List<List<Integer>> triangle, int i, int j){
        if(i == triangle.size()-1){
            return triangle.get(i).get(j);
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int down = solve(triangle,i+1,j);
        int diagonal = solve(triangle,i+1,j+1);
        return dp[i][j] = triangle.get(i).get(j)+Math.min(down,diagonal);
    }
}