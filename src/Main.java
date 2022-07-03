import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Point {
    int x, y;

    public Point(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {
    static int n, m;
    static int[][] box, dis;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    private void BFS(List<Point> list) {
        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) queue.offer(new Point(list.get(i).y, list.get(i).x));
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];
                // 조건 체크
                if (ny >= 0 && ny < n && nx >= 0 && nx < m && box[ny][nx] == 0) {
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
        StringTokenizer tmp = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(tmp.nextToken()); // 6 가로
        n = Integer.parseInt(tmp.nextToken()); // 4 세로
        box = new int[n][m];
        dis = new int[n][m];
        List<Point> list = new ArrayList<>();

        boolean flag = false;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 0) flag = true; // 익지 않은 토마토가 하나라도 있으면
                if (box[i][j] == 1) list.add(new Point(i, j)); // 초기 BFS 시작값
            }
        }
        if (flag) {
            T.BFS(list);
            int answer = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (box[i][j] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    answer = Math.max(answer, dis[i][j]);
                }
            }
            System.out.println(answer);
        } else System.out.println(-1);
    }
}