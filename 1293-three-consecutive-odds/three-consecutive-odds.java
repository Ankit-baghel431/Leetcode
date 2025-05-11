class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int n = arr.length;
        int max = 0;
        int count = 0;
        for(int i = 0;i<n;i++){
            if(arr[i]%2==1){
                count++;
                max = Math.max(max,count);
            } else{
                count = 0;
            }
        }
        if(max >=3){
            return true;
        }
        return false;
    }
}