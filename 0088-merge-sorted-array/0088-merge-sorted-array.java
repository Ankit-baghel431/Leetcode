class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] merge = new int[m+n]; 
        int idx = 0;
        int idx1 = 0;
        int idx2 = 0;
        while (idx1 < m && idx2 < n){
            if(nums1[idx1]<nums2[idx2]){
                merge[idx++] = nums1[idx1++];
            }else{
                merge[idx++] = nums2[idx2++];
            }
        }
        while (idx1 < m) {
            merge[idx++] = nums1[idx1++];
        }

        while (idx2 < n) {
            merge[idx++] = nums2[idx2++];
        }
        for(int i = 0;i<m+n;i++){
            nums1[i] = merge[i];
        }
    }
}