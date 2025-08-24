class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for(int num : prices){
            if(num < min){
                min = num;
            } else {
                max = Math.max(max,num-min);
            }

        }
        return max;
    }
}