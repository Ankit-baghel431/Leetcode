class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int arr [] = new int [n+m];
        int idx = 0;
        for(int i = 0;i<n;i++){
            arr[idx++] = nums1[i];
        }
        for(int i = 0;i<m;i++){
            arr[idx++] = nums2[i];
        }
        Arrays.sort(arr);
        if(arr.length % 2 == 1){
            return arr[arr.length/2];
        }
        return (arr[arr.length/2 -1] + arr[arr.length/2])/2.00;
    }
}