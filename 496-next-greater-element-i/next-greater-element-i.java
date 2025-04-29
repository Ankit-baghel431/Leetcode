class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int [] arr = new int[nums1.length];
        for(int i = 0;i<nums1.length;i++){
            int indx = -1;
            for(int j = 0;j<nums2.length;j++){
                if(nums1[i]==nums2[j]){
                    indx = j;
                    break;
                }
            }
            int max = -1;
            for(int j = indx+1;j<nums2.length;j++){
                if(nums1[i] < nums2[j]){
                    max = nums2[j];
                    break;
                }
            }
            arr[i] = max;
        }
        return arr;
    }
}