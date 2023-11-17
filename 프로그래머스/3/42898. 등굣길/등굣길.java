class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] board = new int[n][m];
        
        for (int[] puddle : puddles) {
            board[puddle[1] - 1][puddle[0] - 1] = -1;
        }
        for (int i = 1; i < n; i++) {
            board[i][0] = (board[i][0] == -1 || board[i - 1][0] == -1) ? -1 : 1;
        }
        for (int i = 1; i < m; i++) {
            board[0][i] = (board[0][i] == -1 || board[0][i - 1] == -1) ? -1 : 1;
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (board[i][j] != -1) {
                    int y = board[i - 1][j] == -1 ? 0 : board[i - 1][j];
                    int x = board[i][j - 1] == -1 ? 0 : board[i][j - 1];
                    board[i][j] = (y + x) == 0 ? -1 : (y + x) % 1_000_000_007;
                }
            }
        }
        
        return board[n - 1][m - 1] == -1 ? 0 : board[n - 1][m - 1];
    }
}