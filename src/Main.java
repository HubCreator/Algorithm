import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int BOARD_SIZE = 7;
    static int[][] board = new int[BOARD_SIZE][BOARD_SIZE];
    static int[][] ch = new int[BOARD_SIZE][BOARD_SIZE];
    static int answer = 0;

    private void DFS(int x, int y) {
        if (x == BOARD_SIZE - 1 && y == BOARD_SIZE - 1) {
            answer++;
        } else {
            // 상하좌우 방향으로 체크
            if (x - 1 > 0 && ch[x - 1][y] == 0 && board[x - 1][y] == 0) {
                ch[x - 1][y] = 1;
                DFS(x - 1, y);
                ch[x - 1][y] = 0;
            }
            if (x + 1 < BOARD_SIZE && ch[x + 1][y] == 0 && board[x + 1][y] == 0) {
                ch[x + 1][y] = 1;
                DFS(x + 1, y);
                ch[x + 1][y] = 0;
            }
            if (y - 1 > 0 && ch[x][y - 1] == 0 && board[x][y - 1] == 0) {
                ch[x][y - 1] = 1;
                DFS(x, y - 1);
                ch[x][y - 1] = 0;
            }
            if (y + 1 < BOARD_SIZE && ch[x][y + 1] == 0 && board[x][y + 1] == 0) {
                ch[x][y + 1] = 1;
                DFS(x, y + 1);
                ch[x][y + 1] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < BOARD_SIZE; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < BOARD_SIZE; j++) board[i][j] = Integer.parseInt(st.nextToken());
        }
        T.DFS(0, 0); // 0, 0에서 출발
        System.out.println(answer);
    }
}