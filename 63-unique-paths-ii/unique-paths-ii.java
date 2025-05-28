class Solution {
    int m;
    int n;
    int dp[][];
    public int uniquePathsWithObstacles(int[][] ob) {
        m = ob.length;
        n = ob[0].length;
        dp = new int[m][n];
        for(int []d : dp){
            Arrays.fill(d,-1);
        }
        return solve(ob,0,0);

    }
    private int solve(int[][] ob , int i,int j){
        if(i >= m || j >= n){
            return 0;
        }
        if(ob[i][j] == 1){
            return 0;
        }
        if(i+1 == m&& j+1 == n){
            return 1;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        return  dp[i][j] = solve(ob,i+1,j)+solve(ob,i,j+1);
    }
}