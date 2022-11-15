import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Point implements Comparable<Point> {
    int y, x, value;

    public Point(int y, int x, int value) {
        this.y = y;
        this.x = x;
        this.value = value;
    }

    @Override
    public int compareTo(Point o) {
        return Integer.compare(value, o.value);
    }
}

public class Solution {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int dy[] = {0, 0, -1, 1};
    static int dx[] = {-1, 1, 0, 0};
    static PriorityQueue<Point> pq;
    static StringBuilder answer = new StringBuilder();

    private static void initialize(BufferedReader br) throws IOException {
        visited = new boolean[N][N];
        visited[0][0] = true;
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j) - '0'; // char -> int
            }
        }
    }

    private static int bfs() {
        pq = new PriorityQueue();
        pq.offer(new Point(0, 0, 0));

        while (!pq.isEmpty()) {
            Point p = pq.poll();
            if (p.y == N - 1 && p.x == N - 1) { // 목적지에 도달했을 때 return
                return p.value;
            }
            for (int i = 0; i < 4; i++) {
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];
                if (ny >= 0 && ny < N && nx >= 0 && nx < N && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    pq.offer(new Point(ny, nx, p.value + map[ny][nx]));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            initialize(br);
            answer.append("#" + test_case + " " + bfs() + "\n");
        }
        System.out.println(answer);
    }
}