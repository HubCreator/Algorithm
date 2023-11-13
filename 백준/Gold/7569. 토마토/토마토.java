import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int[] dy = {-1, 0, 1, 0, 0, 0};
    public static int[] dx = {0, 1, 0, -1, 0, 0};
    public static int[] dz = {0, 0, 0, 0, 1, -1};
    public static Queue<int[]> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[][][] board = new int[H][N][M];

        int emptyCount = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    int target = Integer.parseInt(st2.nextToken());
                    if (target == 1) {
                        queue.offer(new int[]{i, j, k});
                    }
                    if (target == -1) {
                        emptyCount++;
                    }
                    board[i][j][k] = target;
                }
            }
        }
        if (queue.isEmpty()) {
            System.out.print(-1);
            return;
        }
        if (queue.size() + emptyCount == H * N * M) {
            System.out.print(0);
            return;
        }

        int answer = 0, count = queue.size();
        while (!queue.isEmpty() && count + emptyCount < H * N * M) {
            int size = queue.size();
            answer++;
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                for (int d = 0; d < dy.length; d++) {
                    int nZ = poll[0] + dz[d];
                    int nY = poll[1] + dy[d];
                    int nX = poll[2] + dx[d];
                    if (nZ >= 0 && nZ < H &&
                            nY >= 0 && nY < N &&
                            nX >= 0 && nX < M &&
                            board[nZ][nY][nX] == 0) {
                        board[nZ][nY][nX] = 1;
                        queue.offer(new int[]{nZ, nY, nX});
                        count++;
                    }
                }
            }
        }

        for (int[][] h : board) {
            for (int[] n : h) {
                for (int m : n) {
                    if (m == 0) {
                        System.out.print(-1);
                        return;
                    }
                }
            }
        }
        System.out.print(answer);
    }
}