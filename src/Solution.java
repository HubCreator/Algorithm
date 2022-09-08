class Solution {
    private boolean isAllZero(int[][] board) {
        for (int[] col : board) {
            for (int row : col) {
                if (row == 1) return false;
            }
        }
        return true;
    }

    private int isBoardSizeOne(int[][] board) {
        if (board.length == 1 && board[0].length == 1) {
            return board[0][0] == 1 ? 1 : 0;
        }
        return -1;
    }

    public int solution(int[][] board) {
        if (isAllZero(board)) return 0;
        int boardSizeOne = isBoardSizeOne(board);
        if (boardSizeOne >= 0) return boardSizeOne;
        int answer = Integer.MIN_VALUE;
        for (int i = 1; i < board.length; i++) { // y 좌표
            for (int j = 1; j < board[0].length; j++) { // x 좌표
                if (board[i][j] == 0) continue;
                board[i][j] = Math.min(Math.min(board[i][j - 1], board[i - 1][j]), board[i - 1][j - 1]) + 1;
                answer = Math.max(answer, board[i][j]);
            }
        }
        return (int) Math.pow(answer, 2);
    }
}