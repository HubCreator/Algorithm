import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st1.nextToken());
        int n = Integer.parseInt(st1.nextToken());
        int[] arr = new int[n];
        boolean[] check = new boolean[n];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        T.dfs(c, arr, check, sum, 0);
        System.out.println(answer);
    }

    private void dfs(int c, int[] arr, boolean[] check, int sum, int level) {
        if (level == arr.length) {
            if (sum <= c) {
                answer = Math.max(answer, sum);
            }
        } else {
            check[level] = true;
            dfs(c, arr, check, sum + arr[level], level + 1);
            check[level] = false;
            dfs(c, arr, check, sum, level + 1);
        }
    }
}
