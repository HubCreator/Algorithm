import java.util.LinkedList;
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
    int answer = 0;

    private int bfs(Point point) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(point);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Point poll = queue.poll();
                if (poll.y == board.length - 1 && poll.x == board.length - 1) return answer;
                for (int j = 0; j < 4; j++) {
                    int ny = poll.y + dy[j];
                    int nx = poll.x + dx[j];
                    if (ny >= 0 && ny < board.length && nx >= 0 && nx < board.length && board[ny][nx] == 0) {
                        board[ny][nx] = 1;
                        queue.offer(new Point(ny, nx));
                    }
                }
            }
            answer++;
        }
        return answer;
    }

    public int solution(int[][] _board) {
        board = _board;
        
        return bfs(new Point(0, 0));
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