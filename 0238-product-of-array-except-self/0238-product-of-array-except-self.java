class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n =nums.length;
        int [] arr = new int[nums.length];
        arr[0]=1;
        // for(int i = 0; i<n;i++){
        //     int p =1;
        //     for(int j = 0;j<n;j++){
        //         if(j==i){
        //             continue;
        //         }
        //         p *=nums[j];
        //         arr[i] = p;
        //     }
        // }
        for(int i = 1;i<n;i++){
            arr[i] = arr[i-1]*nums[i-1];
        }
        int prod =1;
        for(int i = n-1;i>=0;i--){
            arr[i] *= prod;
            prod *= nums[i];
        }
        return arr;
        
    }
}