import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    private static int dy[] = {-1, 0, 1, 0};
    private static int dx[] = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] arr = new char[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = line.charAt(j);
            }
        }
        int s1 = bfs(arr);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 'R') {
                    arr[i][j] = 'G';
                }
            }
        }
        int s2 = bfs(arr);
        System.out.print(s1 + " " + s2);
    }

    private static int bfs(char[][] arr) {
        int answer = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] check = new boolean[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (!check[i][j]) {
                    check[i][j] = true;
                    queue.offer(new int[]{i, j});
                    answer++;
                    while (!queue.isEmpty()) {
                        int[] poll = queue.poll();
                        for (int d = 0; d < 4; d++) {
                            int ny = poll[0] + dy[d];
                            int nx = poll[1] + dx[d];
                            if (ny >= 0 && ny < arr.length &&
                                    nx >= 0 && nx < arr.length &&
                                    !check[ny][nx] && arr[ny][nx] == arr[poll[0]][poll[1]]) {
                                check[ny][nx] = true;
                                queue.offer(new int[]{ny, nx});
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }
}
