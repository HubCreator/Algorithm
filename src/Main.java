import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int x, y;

    public Point(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {
    static final int SIZE = 7;
    static int[][] board = new int[SIZE + 1][SIZE + 1];
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};

    private int BFS(int y, int x) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(y, x));
        int answer = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Point p = queue.poll();
                for (int j = 0; j < 4; j++) { // 4 방향
                    int ny = p.y + dy[j];
                    int nx = p.x + dx[j];
                    if (ny > 0 && ny <= SIZE && nx > 0 && nx <= SIZE && board[ny][nx] == 0) {
                        if (ny == 7 && nx == 7) return answer + 1;
                        board[ny][nx] = 1;
                        queue.offer(new Point(ny, nx));
                    }
                }
            }
            answer++;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int y = 1; y < SIZE; y++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int x = 1; x < SIZE; x++) board[y][x] = Integer.parseInt(st.nextToken());
        }
        System.out.println(T.BFS(1, 1));
    }
}