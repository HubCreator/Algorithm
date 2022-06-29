import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int BOARD_SIZE = 7;
    static int[][] board = new int[BOARD_SIZE + 1][BOARD_SIZE + 1];
    static int[][] dis = new int[BOARD_SIZE + 1][BOARD_SIZE + 1];
    int[] _x = {-1, 0, 1, 0};
    int[] _y = {0, 1, 0, -1};

    private void BFS(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        board[x][y] = 1;
        queue.offer(new Point(x, y));
        while (!queue.isEmpty()) {
            Point poll = queue.poll();
            for (int j = 0; j < 4; j++) {
                int nx = poll.x + _x[j];
                int ny = poll.y + _y[j];
                if ((nx >= 1 && nx <= BOARD_SIZE && ny >= 1 && ny <= BOARD_SIZE) // board의 범위 내에 있는지 확인
                        && board[nx][ny] == 0) {
                    board[nx][ny] = 1;
                    queue.offer(new Point(nx, ny));
                    dis[nx][ny] = dis[poll.x][poll.y] + 1;
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
        if (dis[BOARD_SIZE][BOARD_SIZE] == 0) System.out.println(-1);
        else System.out.println(dis[BOARD_SIZE][BOARD_SIZE]);
    }
}