class NumMatrix {

    int[][] prematrix;

    public NumMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        prematrix = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                prematrix[i][j] = matrix[i - 1][j - 1] + prematrix[i - 1][j] + prematrix[i][j - 1]
                        - prematrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return prematrix[row2 + 1][col2 + 1] - prematrix[row1][col2 + 1] - prematrix[row2 + 1][col1]
                + prematrix[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */