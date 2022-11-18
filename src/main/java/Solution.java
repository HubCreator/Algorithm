import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static final int BOARD_SIZE = 100;
    static StringBuilder answer = new StringBuilder();
    static StringTokenizer st;
    static int N;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int test_case = 1; test_case <= 10; test_case++) {
            N = Integer.parseInt(br.readLine());
            initialize(br);
            answer.append("#" + N + " " + solution() + "\n");
        }
        System.out.println(answer);
    }

    private static void initialize(BufferedReader br) throws IOException {
        board = new int[BOARD_SIZE][BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static int solution() {
        int max = 0, diagonalASum = 0, diagonalBSum = 0;
        for (int i = 0; i < BOARD_SIZE; i++) {
            int j, rowSum = 0, colSum = 0;
            for (j = 0; j < BOARD_SIZE; j++) {
                rowSum += board[i][j];
                colSum += board[j][i];
            }
            if (i == j) diagonalASum += board[i][j];
            if (BOARD_SIZE - i == j - 1) diagonalBSum += board[j - 1][i];
            max = Math.max(max, Math.max(rowSum, colSum));
        }
        max = Math.max(max, Math.max(diagonalASum, diagonalBSum));
        return max;
    }
}