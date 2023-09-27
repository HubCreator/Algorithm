import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        long[][] dp = new long[65][10];
        Arrays.fill(dp[1], 1);

        for (int i = 2; i < 65; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = j; k < 10; k++) {
                    dp[i][j] += dp[i - 1][k];
                }
            }
        }
        for (int i = 0; i < t; i++) {
            answer.append(solution(dp, Integer.parseInt(br.readLine()))).append('\n');
        }
        System.out.print(answer);
    }

    private static long solution(long[][] dp, int n) {
        long answer = 0;
        for (int i = 0; i < 10; i++) {
            answer += dp[n][i];
        }
        return answer;
    }
}
