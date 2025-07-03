class Solution {
    public String multiply(String nums1, String nums2) {
        if (nums1.equals("0") || nums2.equals("0")) return "0";
        int arr[] = new int[nums1.length()+nums2.length()];
        for (int i = nums1.length()-1;i>=0;i--){
            int a = nums1.charAt(i)-'0';
            for(int j = nums2.length()-1;j>=0;j--){
                int b = nums2.charAt(j)-'0';

                int mul = a*b;

                int pos1 = i+j;
                int pos2 = i+j+1;

                int sum = mul+arr[pos2];
                arr[pos2] = sum%10;
                arr[pos1] += sum/10;
            }

        }
        StringBuilder sb = new StringBuilder();
        for(int num : arr){
            if(!(sb.length()==0 && num==0)){
                sb.append(num);
            }
        }
        return sb.toString();
    }
}