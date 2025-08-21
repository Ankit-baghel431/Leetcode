class Solution {
    public double average(int[] salary) {
        int max = -1;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for(int num : salary){
            max = Math.max(max,num);
            min = Math.min(min,num);
            sum += num;
        }
        sum = sum-max-min;
        return (double)sum/(salary.length-2);
    }
}