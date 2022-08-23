import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Point {
    int y, x;

    public Point(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

class Solution {
    int[][] board;
    int[] dy = {0, -1, 0, 1};
    int[] dx = {1, 0, -1, 0};

    private int bfs(int n, int m, List<Point> list) {
        Queue<Point> queue = new LinkedList<>(list);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point poll = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int ny = poll.y + dy[j];
                    int nx = poll.x + dx[j];
                    if (ny >= 0 && ny < n && nx >= 0 && nx < m && board[ny][nx] == 0) {
                        board[ny][nx] = 1;
                        queue.offer(new Point(ny, nx));
                    }
                }
            }
            level++;
        }

        return level;
    }

    public int solution(int n, int m, int[][] _board) {
        List<Point> list = new ArrayList<>();
        board = _board;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j] == 1) list.add(new Point(i, j));
            }
        }

        int result = bfs(n, m, list);

        return result;
    }


    public static void main(String[] args) {
        Solution T = new Solution();
        int n = 4;
        int m = 6;
        int[][] board = {
                {0, 0, -1, 0, 0, 0},
                {0, 0, 1, 0, -1, 0},
                {0, 0, -1, 0, 0, 0},
                {0, 0, 0, 0, -1, 1}
        };

        System.out.println(T.solution(n, m, board));
    }
}