class Solution {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int sum = 0;
        int i = 0;
        int j = 0;
        while(i<n){
            sum += mat[i++][j++];
        }
        i = 0;
        j = m-1;
        while(i<n){
            sum += mat[i++][j--];
        }
        i = n/2;
        j = m/2;
        if(n%2 != 0){
        return sum-mat[i][j];
        }
        return sum;
    }
}