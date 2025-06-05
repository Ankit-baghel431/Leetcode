class Solution {
    public int maxProfit(int[] prices) {
        int[][][] dp=new int[prices.length][2][3];
        for(int[][] t:dp)
        {
            for(int[] c:t)
            {
                Arrays.fill(c,-1);
            }
        }
        return solve(0,1,prices,0,dp);
    }
    int solve(int ind,int buy,int[] prices,int count,int[][][] dp)
    {
        if(ind==prices.length)
        return 0;
        if(count==2)
        return 0;
        if(dp[ind][buy][count]!=-1)
        return dp[ind][buy][count];
        int profit=0;
        if(buy==1 && count<2)
        {
            int op1=-prices[ind]+solve(ind+1,0,prices,count,dp);
            int op2=solve(ind+1,1,prices,count,dp);
            profit=Math.max(op1,op2);
        }
        else
        {
            int op1=prices[ind]+solve(ind+1,1,prices,count+1,dp);
            int op2=solve(ind+1,0,prices,count,dp);
            profit=Math.max(op1,op2);
        }
        dp[ind][buy][count]=profit;
        return dp[ind][buy][count];
    }
}