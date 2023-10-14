import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int dy[] = new int[]{-1, 0, 1, 0};
    private static int dx[] = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st2.nextToken());
            }
        }
        System.out.print(bfs(arr));
    }

    private static int bfs(int[][] arr) {
        Queue<int[]> queue = new ArrayDeque<>();
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int d = 0; d < 4; d++) {
                int ny = poll[0] + dy[d];
                int nx = poll[1] + dx[d];
                if (ny >= 0 && ny < arr.length &&
                        nx >= 0 && nx < arr[0].length &&
                        arr[ny][nx] == 0) {
                    arr[ny][nx] = arr[poll[0]][poll[1]] + 1;
                    queue.offer(new int[]{ny, nx});
                }
            }
        }
        for (int[] ints : arr) {
            for (int anInt : ints) {
                if (anInt == 0) {
                    return -1;
                }
                answer = Math.max(answer, anInt);
            }
        }
        return answer - 1;
    }
}
