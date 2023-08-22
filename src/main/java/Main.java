import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n]; // 래퍼 타입이어야 Collections 프레임워크 사용 가능
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, Collections.reverseOrder()); // 최적화 여지

        int m = Integer.parseInt(br.readLine());

        T.dfs(arr, n, m, 0, 0);
        System.out.println(answer);
    }

    private void dfs(Integer[] arr, int n, int m, int sum, int level) {
        if (sum > m || level > answer) { // 최적화
            return;
        }
        if (sum == m) {
            answer = Math.min(answer, level);
        } else {
            for (int i = 0; i < n; i++) {
                dfs(arr, n, m, sum + arr[i], level + 1);
            }
        }
    }
}
