import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        int[] dp = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        int answer = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                if (arr[i] > arr[j]) { // 이전 값보다 크면
                    dp[i] = Math.max(dp[i], dp[j] + 1); // 이전값보다 1을 더한것과 현재값 중 최댓값으로 갱신
                }
            }
            answer = Math.max(answer, dp[i]); // 정답값 갱신 (길이의 최댓값)
        }

        System.out.print(answer);
    }
}