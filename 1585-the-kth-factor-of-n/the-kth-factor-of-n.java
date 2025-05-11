class Solution {
    public int kthFactor(int n, int k) {
        int [] arr = new int[n];
        arr[0] = 1;
        int m = 1;
        for(int i = 2;i<=n;i++){
            if(n%i==0){
                arr[m] = i;
                m++;
            }
        }
        if(arr[k-1] == 0) return -1;
        return arr[k-1];
    }
}