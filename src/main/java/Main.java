import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());
        int[] arr = new int[n];
        int[] pm = new int[n];
        boolean[] check = new boolean[n];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }
        T.dfs(n, m, arr, pm, check, 0);
    }

    private void dfs(int n, int m, int[] arr, int[] pm, boolean[] check, int level) {
        if (level == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(pm[i] + " ");
            }
            System.out.println();
        } else {
            for (int i = 0; i < n; i++) {
                if (!check[i]) {
                    check[i] = true;
                    pm[level] = arr[i];
                    dfs(n, m, arr, pm, check, level + 1);
                    check[i] = false;
                }
            }
        }
    }
}
