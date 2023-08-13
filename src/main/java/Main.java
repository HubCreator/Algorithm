import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int[] arr;
    private static boolean[] check;
    private static boolean answer;

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        check = new boolean[n];
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        T.dfs(0);
        System.out.println(answer);
    }

    private void dfs(int level) {
        if (level == n) {
            int sum1 = 0, sum2 = 0;
            for (int i = 0; i < check.length; i++) {
                if (check[i]) {
                    sum1 += arr[i];
                } else {
                    sum2 += arr[i];
                }
            }
            if (sum1 == sum2) {
                answer = true;
            }
        } else {
            check[level] = true;
            dfs(level + 1);
            check[level] = false;
            dfs(level + 1);
        }
    }
}
