class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp=new int[prices.length+1][2];
        for(int[] c:dp)
        {
            Arrays.fill(c,-1);
        }
        return solve(0,1,prices,dp);
    }
    int solve(int ind,int buy,int[] arr,int[][] dp)
    {
        if(ind==arr.length)
        return 0;
        if(dp[ind][buy]!=-1)
        return dp[ind][buy];
        int profit=0;
        if(buy==1)
        {
            int op1=-arr[ind]+solve(ind+1,0,arr,dp);
            int op2=solve(ind+1,1,arr,dp);
            profit=Math.max(op1,op2);
        }
        else
        {
            int op1=arr[ind]+solve(ind+1,1,arr,dp);
            int op2=solve(ind+1,0,arr,dp);
            profit=Math.max(op1,op2);
        }
        dp[ind][buy]= profit;
        return dp[ind][buy];
    }
}