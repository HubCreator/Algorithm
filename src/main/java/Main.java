import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int[][] board = new int[15][15];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        initBoard();
        int t = Integer.parseInt(br.readLine());
        int[] kArr = new int[t];
        int[] nArr = new int[t];
        for (int i = 0; i < t; i++) {
            kArr[i] = Integer.parseInt(br.readLine());
            nArr[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < t; i++) {
            System.out.println(board[kArr[i]][nArr[i] - 1]);
        }
    }

    private static void initBoard() {
        for (int i = 0; i < board.length; i++) {
            board[0][i] = i + 1;
        }
        for (int i = 1; i < board.length; i++) {
            int sum = 0;
            for (int j = 0; j < board[i].length; j++) {
                sum += board[i - 1][j];
                board[i][j] = sum;
            }
        }
    }
}
