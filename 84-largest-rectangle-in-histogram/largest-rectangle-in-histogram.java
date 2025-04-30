class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        Stack<Integer> s = new Stack<>();
        int n = heights.length;
        for(int i = 0;i<=n;i++){
            int currmax = (i == n) ? 0 : heights[i];
            while(!s.isEmpty() && currmax < heights[s.peek()]){
                int height = heights[s.pop()];
                int width = s.isEmpty() ? i : i - s.peek()-1;
                max = Math.max(max,height*width);
            }
            s.push(i);
        }
        return max;
    }
}