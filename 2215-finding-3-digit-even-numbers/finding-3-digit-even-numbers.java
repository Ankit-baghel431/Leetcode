class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> set = new HashSet<>(); 
        int n = digits.length;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                for(int k = 0;k<n;k++){
                    if (i == j || j == k || i == k) continue;
                    int d1 = digits[i];
                    int d2 = digits[j];
                    int d3 = digits[k];
                    if(d1 == 0 || d3%2 !=0) continue;
                    int num = d1*100+d2*10+d3;
                    set.add(num);
                }
            }
        }
        int[] result = new int[set.size()];
        int index = 0;
        for (int num : set) {
            result[index++] = num;
        }
        Arrays.sort(result);
        return result;
    }
}