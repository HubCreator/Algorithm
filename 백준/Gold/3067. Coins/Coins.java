import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] coin = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                coin[j] = Integer.parseInt(st.nextToken());
            }
            int M = Integer.parseInt(br.readLine());
            answer.append(solution(coin, N, M)).append('\n');
        }
        System.out.print(answer);
    }

    private static int solution(int[] coin, int n, int m) {
        int[] dp = new int[10001];
        dp[0] = 1;
        for (int i = 0; i < n; i++) { // 코인 종류의 갯수
            for (int j = coin[i]; j <= m; j++) { // 해당 코인부터 목표 m까지 점차 키워나감
                dp[j] += dp[j - coin[i]];  
            }
        }
        return dp[m];
    }
}
