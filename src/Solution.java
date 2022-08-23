
class Solution {
    int[][] board, ch;
    int[] dy = {0, -1, 0, 1};
    int[] dx = {1, 0, -1, 0};
    int answer = 0;


    private void dfs(int y, int x) {
        if (y == board.length - 1 && x == board.length - 1) answer++;
        else {
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny >= 0 && ny < board.length && nx >= 0 && nx < board.length && ch[ny][nx] == 0 && board[ny][nx] == 0) {
                    ch[ny][nx] = 1;
                    dfs(ny, nx);
                    ch[ny][nx] = 0;
                }
            }
        }
    }

    public int solution(int[][] _board) {
        board = _board;
        ch = new int[board.length][board.length];
        ch[0][0] = 1;
        dfs(0, 0);

        return answer;
    }


    public static void main(String[] args) {
        Solution T = new Solution();
        int[][] board = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {1, 1, 0, 1, 0, 1, 1},
                {1, 1, 0, 0, 0, 0, 1},
                {1, 1, 0, 1, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 0}
        };
        System.out.println(T.solution(board));
    }
}