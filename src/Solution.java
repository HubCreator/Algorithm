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
    static int[][] board;
    static int width, height;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    private int BFS(int y, int x) {
        Queue<Point> queue = new LinkedList<>();
        int level = 0;
        queue.offer(new Point(y, x));
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Point p = queue.poll();
                if (p.y == height - 1 && p.x == width - 1) return level + 1;
                for (int j = 0; j < 4; j++) {
                    int ny = p.y + dy[j];
                    int nx = p.x + dx[j];
                    if (ny >= 0 && ny < height && nx >= 0 && nx < width && board[ny][nx] == 1) {
                        board[ny][nx] = 0;
                        queue.offer(new Point(ny, nx));
                    }
                }
            }
            level++;
        }
        return -1;
    }

    public int solution(int[][] maps) {
        board = maps;
        height = maps.length;
        width = maps[0].length;
        return BFS(0, 0);
    }
}