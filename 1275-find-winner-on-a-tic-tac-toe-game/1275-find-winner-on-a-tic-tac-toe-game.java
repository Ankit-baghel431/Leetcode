class Solution {
    public String tictactoe(int[][] moves) {
        int n = 3;
        int[] rows = new int[n];
        int[] cols = new int[n];
        int diag = 0, antiDiag = 0;
        
        for (int i = 0; i < moves.length; i++) {
            int r = moves[i][0], c = moves[i][1];
            int player = (i % 2 == 0) ? 1 : -1; // A = +1, B = -1
            
            rows[r] += player;
            cols[c] += player;
            if (r == c) diag += player;
            if (r + c == n - 1) antiDiag += player;
            
            if (Math.abs(rows[r]) == n || Math.abs(cols[c]) == n ||
                Math.abs(diag) == n || Math.abs(antiDiag) == n) {
                return player == 1 ? "A" : "B";
            }
        }
        
        return moves.length == n * n ? "Draw" : "Pending";
    }
}