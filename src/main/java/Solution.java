class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        boolean[][] board = new boolean[n + 1][n + 1];
        for (int[] result : results) {
            board[result[0]][result[1]] = true;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (board[i][k] && board[k][j]) {
                        board[i][j] = true;
                    }
                }
            }
        }

        for (int p = 1; p <= n; p++) {
            int win = 0, lose = 0;
            for (int i = 1; i <= n; i++) {
                if (board[p][i]) {
                    win++;
                }
                if (board[i][p]) {
                    lose++;
                }
            }
            if (win + lose == n - 1) {
                answer++;
            }
        }
        return answer;
    }
}
