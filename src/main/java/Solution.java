import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static StringBuilder answer = new StringBuilder();
    static StringTokenizer st;
    static int N;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int test_case = 1; test_case <= 10; test_case++) {
            initialize(br);
            answer.append("#" + test_case + " " + solution() + "\n");
        }
        System.out.println(answer);
    }

    private static int solution() {
        int result = 0;
        for (int col = 0; col < N; col++) {
            StringBuilder sb = new StringBuilder();
            for (int row = 0; row < N; row++) {
                if (board[row][col] != 0) sb.append(board[row][col]);
            }
            for (int i = 0; i < sb.length() - 1; i++) {
                if (sb.charAt(i) == '1' && sb.charAt(i + 1) == '2') result++;
            }
        }
        return result;
    }

    private static void initialize(BufferedReader br) throws IOException {
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}