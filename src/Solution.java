class Point {
    int y, x;

    public Point(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Solution {
    int answer = 0;
    int[][] ch;
    int[] dy = {-1, 0, 1, 0};
    int[] dx = {0, 1, 0, -1};

    private void dfs(int y, int x, int[][] board) {
        if (y == board.length - 1 && x == board.length - 1) {
            answer++;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny >= 0 && ny < board.length && nx >= 0 && nx < board.length && board[ny][nx] == 0 && ch[ny][nx] == 0) {
                ch[ny][nx] = 1;
                dfs(ny, nx, board);
                ch[ny][nx] = 0;
            }
        }
    }

    public int solution(int[][] board) {
        ch = new int[board.length][board.length];
        dfs(0, 0, board);
        return answer;
    }


    public static void main(String[] args) {
        Solution T = new Solution();
        int[][] board = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {1, 1, 0, 1, 0, 1, 1},
                {1, 1, 0, 0, 0, 0, 1},
                {1, 1, 0, 1, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 0}
        };
        System.out.println(T.solution(board));
    }
}