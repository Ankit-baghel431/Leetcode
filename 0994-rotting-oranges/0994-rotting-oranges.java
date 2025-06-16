class Solution {
    private static class Pair {
        int row;
        int col;
        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> queue = new LinkedList<>();
        int freshcount = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if (grid[i][j] == 2) {
                    queue.add(new Pair(i, j));
                } else if (grid[i][j] == 1) {
                    freshcount++;
                }
            }
        }
        int minute = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rotted = false;
            for (int i = 0; i < size; i++) {
                Pair p = queue.poll();
                int r = p.row;
                int c = p.col;
                if (r - 1 >= 0 && grid[r - 1][c] == 1) {
                    grid[r - 1][c] = 2;
                    queue.add(new Pair(r - 1, c));
                    freshcount--;
                    rotted = true;
                }
                if (r + 1 < n && grid[r + 1][c] == 1) {
                    grid[r + 1][c] = 2;
                    queue.add(new Pair(r + 1, c));
                    freshcount--;
                    rotted = true;
                }
                if (c - 1 >= 0 && grid[r][c - 1] == 1) {
                    grid[r][c - 1] = 2;
                    queue.add(new Pair(r, c - 1));
                    freshcount--;
                    rotted = true;
                }
                if (c + 1 < m && grid[r][c + 1] == 1) {
                    grid[r][c + 1] = 2;
                    queue.add(new Pair(r, c + 1));
                    freshcount--;
                    rotted = true;
                }
            }
            if (rotted) {
                minute++;
            }
        }
        if(freshcount == 0){
            return minute;
        }
        return -1;
    }
}