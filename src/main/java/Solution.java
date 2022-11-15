import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

class Point {
    int y, x;

    public Point(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Solution {
    static StringBuilder answer = new StringBuilder();
    static int n;
    static int[][] board, dis;
    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};

    private static void bfs() {
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(0, 0));
        dis[0][0] = 0;
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];
                if (ny >= 0 && ny < n && nx >= 0 && nx < n && board[ny][nx] != -1) {
                    dis[ny][nx] = Math.min(dis[ny][nx], dis[p.y][p.x] + board[ny][nx]);
                    queue.offer(new Point(ny, nx));
                    board[p.y][p.x] = -1; // 지나갔던 경로를 -1 표시
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            n = Integer.parseInt(br.readLine());
            initialize(br);
            bfs();
            answer.append("#" + test_case + " " + dis[n - 1][n - 1] + "\n");
        }
        System.out.println(answer);
    }

    private static void initialize(BufferedReader br) throws IOException {
        dis = new int[n][n];
        int row = 0;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                board[row][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
                dis[i][j] = Integer.MAX_VALUE;
            }
            row++;
        }
    }
}