class Solution {
    int totalPaths = 0;
    int totalSteps = 0;

    public int uniquePathsIII(int[][] grid) {
        int startX = 0, startY = 0;

        // Count total walkable cells and find starting point
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != -1) {
                    totalSteps++;
                }
                if (grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                }
            }
        }

        dfs(grid, startX, startY, 0);
        return totalPaths;
    }

    private void dfs(int[][] grid, int i, int j, int steps) {
        // Out of bounds or obstacle
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == -1) return;

        // If end point
        if (grid[i][j] == 2) {
            if (steps + 1 == totalSteps) {
                totalPaths++;
            }
            return;
        }

        // Save current cell and mark as visited
        int temp = grid[i][j];
        grid[i][j] = -1;

        // Explore in 4 directions
        dfs(grid, i + 1, j, steps + 1);
        dfs(grid, i - 1, j, steps + 1);
        dfs(grid, i, j + 1, steps + 1);
        dfs(grid, i, j - 1, steps + 1);

        // Backtrack
        grid[i][j] = temp;
    }
}
