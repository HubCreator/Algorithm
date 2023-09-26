import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        StringTokenizer st3 = new StringTokenizer(br.readLine());
        int[][] board = new int[2][3];
        for (int i = 0; i < 3; i++) {
            board[0][i] = Integer.parseInt(st2.nextToken());
            board[1][i] = Integer.parseInt(st3.nextToken());
        }
        solution(board, n, m, 0, Integer.MIN_VALUE, 0);
        System.out.println(count);
    }

    private static void solution(int[][] board, int n, int m, int sum, int last, int level) {
        if (level == n) {
            if (sum >= m) {
                count++;
            }
        } else {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (j == last) {
                        solution(board, n, m, sum + (board[i][j] / 2), j, level + 1);
                    } else {
                        solution(board, n, m, sum + board[i][j], j, level + 1);
                    }
                }
            }
        }
    }
}
