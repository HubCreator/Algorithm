import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int x, y;

    Point(int y, int x) {
        this.y = y;
        this.x = x;
    }
}
public class Main {
    int[] dy = {1, -1, -1, 0, 1, 1, -1, 0};
    int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};
    static int n;
    static int[][] board;

    private void BFS(int y, int x) {
        Queue<Point> queue = new LinkedList<>();
        board[y][x] = 0;
        queue.offer(new Point(y, x));
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int i = 0; i < 8; i++) {
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];
                if (ny >= 0 && ny < n && nx >= 0 && nx < n && board[ny][nx] == 1) {
                    board[ny][nx] = 0;
                    queue.offer(new Point(ny, nx));
                }
            }
        }
    }

    private int solution() {
        int answer = 0;
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                if (board[y][x] == 1) {
                    answer++;
                    BFS(y, x);
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) board[i][j] = Integer.parseInt(st.nextToken());
        }
        System.out.println(T.solution());
    }
}