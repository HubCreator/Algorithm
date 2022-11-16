import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static StringBuilder answer = new StringBuilder();
    static int T, N;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine().trim());
        for (int test_case = 1; test_case <= T; test_case++) {
            initialize(br);
            answer.append("#" + test_case + " " + solution() + "\n");
        }
        System.out.println(answer);
    }

    private static void initialize(BufferedReader br) throws IOException {
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = str.charAt(j) - '0';
            }
        }
    }

    private static int solution() {
        int cnt = 0, level = 0, sum = 0;
        int mid = (N / 2);

        while (level < N) {
            for (int j = mid - cnt; j <= mid + cnt; j++) {
                sum += board[level][j];
            }
            cnt = level < mid ? cnt + 1 : cnt - 1;
            level++;
        }
        return sum;
    }
}