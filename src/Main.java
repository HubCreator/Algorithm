import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
    public static final int BOARD_SIZE = 7;
    public static int[][] board = new int[BOARD_SIZE + 1][BOARD_SIZE + 1];
    public static int[][] dis = new int[BOARD_SIZE + 1][BOARD_SIZE + 1];

    public int[] dx = {-1, 0, 1, 0};
    public int[] dy = {0, 1, 0, -1};

    private void BFS(int y, int x) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(y, x));
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int j = 0; j < 4; j++) {
                int ny = p.y + dy[j];
                int nx = p.x + dx[j];
                if (ny > 0 && ny <= BOARD_SIZE && nx > 0 && nx <= BOARD_SIZE && board[ny][nx] == 0) {
                    board[ny][nx] = 1;
                    queue.offer(new Point(ny, nx));
                    dis[ny][nx] = dis[p.y][p.x] + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 1; i <= BOARD_SIZE; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= BOARD_SIZE; j++) board[i][j] = Integer.parseInt(st.nextToken());
        }
        T.BFS(1, 1);
        System.out.println(dis[BOARD_SIZE][BOARD_SIZE]);
    }
}