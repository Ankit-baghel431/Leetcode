class Solution {
    public int trap(int[] height) {
        // Better Approch
        // int n = height.length;
        // int [] leftmax = new int[n];
        // leftmax[0] = height[0];
        // int [] rightmax = new int[n];
        // rightmax[n-1] = height[n-1];
        // for(int i = 1; i<n; i++){
        //     leftmax[i] = Math.max(height[i],leftmax[i-1]);
        // }
        // for(int i =  n-2; i>=0; i--){
        //     rightmax[i] = Math.max(height[i],rightmax[i+1]);
        // }
        // int maxWater = 0;
        // for(int i = 0; i<n; i++){
        //     maxWater +=  Math.min(leftmax[i],rightmax[i])-height[i];
        // }
        // return maxWater;
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        int water = 0;
        while (left < right) {
            if (leftMax < rightMax) {
                left++;
                leftMax = Math.max(leftMax, height[left]);
                water += leftMax - height[left];
            } else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                water += rightMax - height[right];
            }
        }
        return water;
    }
}