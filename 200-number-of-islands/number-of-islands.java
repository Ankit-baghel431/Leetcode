class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int count = 0;
        int n = grid.length;
        int m = grid[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    markIsland(grid, i, j, n, m);
                }
            }
        }

        return count;
    }
    private void markIsland(char[][] grid, int i, int j, int n, int m) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '0';
        markIsland(grid, i + 1, j, n, m);
        markIsland(grid, i - 1, j, n, m);
        markIsland(grid, i, j + 1, n, m);
        markIsland(grid, i, j - 1, n, m);
    }
}