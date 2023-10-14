import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            long[][] dp = initDp(n);
            answer.append(1 + dp[n][2] + dp[n][3]).append(System.lineSeparator());
        }
        System.out.print(answer);
    }

    private static long[][] initDp(int n) {
        long[][] dp = new long[10001][4];
        dp[2][2] = 1;

        dp[3][2] = 1;
        dp[3][3] = 1;

        dp[4][2] = 2;
        dp[4][3] = 1;

        for (int i = 5; i < dp.length; i++) {
            dp[i][2] = i / 2;
            dp[i][3] = 1 + dp[i - 3][2] + dp[i - 3][3];
        }
        return dp;
    }
}
