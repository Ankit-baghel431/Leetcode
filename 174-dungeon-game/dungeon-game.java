class Solution {
    int m;
    int n;
    int dp[][];
    public int calculateMinimumHP(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        dp = new int[m][n];
        for(int []d : dp){
            Arrays.fill(d,-1001);
        }
        return solve(grid,0,0);
    }
    private int solve(int[][] ob , int i,int j){
        if (i >= m || j >= n) {
            return Integer.MAX_VALUE;
        }
        if (i == m - 1 && j == n - 1) {
            return Math.max(1, 1 - ob[i][j]);
        }
        if(dp[i][j] != -1001){
            return dp[i][j];
        }

        int down = solve(ob,i+1,j);
        int right = solve(ob,i,j+1);
        int need = Math.min(down, right);
        dp[i][j] = Math.max(1, need - ob[i][j]);
        return dp[i][j];
    }
}