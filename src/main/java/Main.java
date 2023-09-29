import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int count = 0;
    private static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[]{1, 2, 3};
        int[] pm = new int[11];
        dfs(n, k, arr, pm, 0, 0);
        if (answer.length() > 0) {
            System.out.print(answer);
        } else {
            System.out.print(-1);
        }
    }

    private static void dfs(int n, int k, int[] arr, int[] pm, int sum, int level) {
        if (sum > n) {
            return;
        } else if (sum == n) {
            count++;
            if (count == k) {
                for (int i = 0; i < level; i++) {
                    answer.append(pm[i] + 1).append('+');
                }
                answer.deleteCharAt(answer.length() - 1);
            }
        } else {
            for (int i = 0; i < arr.length; i++) {
                pm[level] = i;
                dfs(n, k, arr, pm, sum + arr[i], level + 1);
            }
        }
    }
}
