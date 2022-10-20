class Solution {
    int answer = Integer.MIN_VALUE;

    public int solution(int[][] board) {
        int tmp = 0;
        for (int[] ints : board) {
            for (int x : ints) {
                tmp += x;
            }
        }
        if (tmp == (int) Math.pow(board.length, 2)) {
            return tmp;
        } else if (tmp == 0) {
            return 0;
        }

        findMaxRect(board);
        return (int) Math.pow(answer, 2);
    }

    private void findMaxRect(int[][] board) {

        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[i].length; j++) {
                if (board[i][j] == 0) continue;
                board[i][j] = Math.min(Math.min(board[i - 1][j], board[i][j - 1]), board[i - 1][j - 1]) + 1;
                answer = Math.max(answer, board[i][j]);
            }
        }
    }
}