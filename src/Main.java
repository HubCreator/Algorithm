import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] board, dis;
    static int n;
    int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};
    int[] dy = {1, -1, -1, 0, 1, 1, -1, 0};

    private void DFS(int _x, int _y) {
        for (int i = 0; i < 8; i++) { // 8 방향
            int nx = _x + dx[i];
            int ny = _y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[ny][nx] == 1) {
                board[ny][nx] = 0;
                DFS(nx, ny);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        dis = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) board[i][j] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;
        boolean flag;
        do {
            flag = false;
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < n; x++) {
                    if (board[y][x] == 1) {
                        board[y][x] = 0;
                        T.DFS(x, y);
                        answer++;
                        flag = true;
                    }
                }
            }
        } while (flag);
        System.out.println(answer);
    }
}