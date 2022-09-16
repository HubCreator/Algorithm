import java.util.LinkedList;
import java.util.Queue;

class Point {
    int y, x, val;

    public Point(int y, int x, int val) {
        this.y = y;
        this.x = x;
        this.val = val;
    }
}

class Solution {
    int[] dy = {-1, 0, 1, 0};
    int[] dx = {0, 1, 0, -1};

    private int bfs(int y, int x, int[][] picture) {
        Queue<Point> queue = new LinkedList<>();
        int cnt = 1;
        queue.offer(new Point(y, x, picture[y][x]));
        picture[y][x] = 0;
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];
                if (ny >= 0 && ny < picture.length && nx >= 0 && nx < picture[0].length && picture[ny][nx] == p.val) {
                    queue.offer(new Point(ny, nx, p.val));
                    picture[ny][nx] = 0;
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0, maxSizeOfOneArea = Integer.MIN_VALUE;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] > 0) {
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, bfs(i, j, picture));
                }
            }
        }

        return new int[]{numberOfArea, maxSizeOfOneArea};
    }
}