import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static StringBuilder answer = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            initialize(br);
            answer.append("#" + test_case + " " + mainLogic() + "\n");
        }
        System.out.println(answer);
    }

    private static int mainLogic() {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= N - M; i++) {
            for (int j = 0; j <= N - M; j++) {
                int sum = 0;
                for (int k = i; k < i + M; k++) {
                    for (int l = j; l < j + M; l++) {
                        sum += board[k][l];
                    }
                }
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    private static void initialize(BufferedReader br) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}