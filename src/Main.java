import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int y, x;

    public Point(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {
    static int xL, yL;
    static int[][] box, dis;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    private void BFS(ArrayList<Point> startAt) {
        Queue<Point> queue = new LinkedList<>();
        for (Point point : startAt) queue.offer(point);
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];
                if (ny >= 0 && ny < yL && nx >= 0 && nx < xL && box[ny][nx] == 0) {
                    box[ny][nx] = 1;
                    queue.offer(new Point(ny, nx));
                    dis[ny][nx] = dis[p.y][p.x] + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        xL = Integer.parseInt(st.nextToken());
        yL = Integer.parseInt(st.nextToken());
        box = new int[yL][xL];
        dis = new int[yL][xL];
        ArrayList<Point> startAt = new ArrayList<>();
        for (int i = 0; i < yL; i++) {
            StringTokenizer tmp = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < xL; j++) {
                int t = Integer.parseInt(tmp.nextToken());
                if (t == 1) startAt.add(new Point(i, j));
                box[i][j] = t;
            }
        }
        T.BFS(startAt);


        int max = Integer.MIN_VALUE;
        boolean flag = true;

        Loop1:
        for (int y = 0; y < yL; y++) {
            for (int x = 0; x < xL; x++) {
                max = Math.max(max, dis[y][x]);
                if (dis[y][x] == 0 && box[y][x] == 0) {
                    flag = false;
                    break Loop1;
                }
            }
        }

        if (flag) System.out.println(max);
        else System.out.println(-1);
    }
}