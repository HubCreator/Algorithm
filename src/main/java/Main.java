import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[] dy = {-1, 0, 1, 0};
    private static int[] dx = {0, 1, 0, -1};
    private static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[][] arr = new boolean[N + 1][M + 1];
        for (int i = 0; i < K; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st2.nextToken());
            int c = Integer.parseInt(st2.nextToken());
            arr[r][c] = true;
        }
        System.out.print(solution(arr));
    }

    private static int solution(boolean[][] arr) {
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j]) {
                    boolean[][] check = new boolean[arr.length][arr[i].length];
                    check[i][j] = true;
                    count = 1;
                    dfs(arr, check, i, j);
                    answer = Math.max(answer, count);
                }
            }
        }
        return answer;
    }

    private static void dfs(boolean[][] arr, boolean[][] check, int i, int j) {
        for (int d = 0; d < 4; d++) {
            int ny = dy[d] + i;
            int nx = dx[d] + j;
            if (ny >= 0 && ny < check.length &&
                    nx >= 0 && nx < check[0].length &&
                    arr[ny][nx] && !check[ny][nx]) {
                check[ny][nx] = true;
                count++;
                dfs(arr, check, ny, nx);
            }
        }
    }

}
