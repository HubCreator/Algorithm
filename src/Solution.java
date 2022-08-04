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
    static int[][] pic;
    static int[] dy;
    static int[] dx;

    private int bfs(int m, int n, Point p) {
        int sum = 0;
        Queue<Point> queue = new LinkedList<>();
        queue.offer(p);
        pic[p.y][p.x] = 0;

        while (!queue.isEmpty()) {
            Point poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = poll.y + dy[i];
                int nx = poll.x + dx[i];
                if (ny >= 0 && ny < m && nx >= 0 && nx < n && pic[ny][nx] == p.val) {
                    pic[ny][nx] = 0;
                    queue.offer(new Point(ny, nx, pic[ny][nx]));
                }
            }
            sum++;
        }
        return sum;
    }

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0, maxSizeOfOneArea = Integer.MIN_VALUE;
        dx = new int[]{-1, 0, 1, 0};
        dy = new int[]{0, 1, 0, -1};
        pic = new int[picture.length][picture[0].length];
        for (int i = 0; i < picture.length; i++) pic[i] = picture[i].clone();

        for (int i = 0; i < pic.length; i++) {
            for (int j = 0; j < pic[i].length; j++) {
                if (pic[i][j] != 0) {
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, bfs(m, n, new Point(i, j, pic[i][j])));
                }
            }
        }
        return new int[]{numberOfArea, maxSizeOfOneArea};
    }
}