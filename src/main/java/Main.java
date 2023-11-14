import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static boolean[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        board = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j) == 'W';
            }
        }

        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                answer = Math.min(answer, solution(i, j));
            }
        }
        System.out.print(answer);
    }

    private static int solution(int y, int x) {
        int count = 0;
        boolean flag = board[y][x];
        for (int i = y; i < y + 8; i++) {
            for (int j = x; j < x + 8; j++) {
                if (board[i][j] != flag) {
                    count++;
                }
                flag = !flag;
            }
            flag = !board[i][0];
        }
        return Math.min(count, 64 - count);
    }
}