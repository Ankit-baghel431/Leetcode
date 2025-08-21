class Solution {
    public int maximumWealth(int[][] accounts) {
        int n = accounts.length;
        int m = accounts[0].length;
        int max = -1;
        for(int i = 0;i<n;i++){
            int amount = 0;
            for(int j = 0;j<m;j++){
                amount+=accounts[i][j];
            }
            if(max < amount){
                max = amount;
            }
        }
        return max;
    }
}