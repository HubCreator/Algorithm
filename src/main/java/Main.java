import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());
        int[][] board = new int[n + 1][m + 1];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            board[i][0] = Integer.parseInt(st2.nextToken());
        }
        StringTokenizer st3 = new StringTokenizer(br.readLine());
        for (int i = 1; i <= m; i++) {
            board[0][i] = Integer.parseInt(st3.nextToken());
        }
        System.out.println(solution(board));
    }

    private static int solution(int[][] board) {
        int i = 0, j = 0;
        for (i = 1; i < board[0].length; i++) {
            for (j = 1; j < board.length; j++) {
                if (board[j][i - 1] == board[j - 1][i]) {
                    board[j][i] = 0;
                } else {
                    board[j][i] = 1;
                }
            }
        }
        return board[j - 1][i - 1];
    }
}
