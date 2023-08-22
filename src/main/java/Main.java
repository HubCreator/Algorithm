import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] pm = new int[m];

        T.dfs(pm, n, m, 0);
    }

    private void dfs(int[] pm, int n, int m, int level) {
        if (level == m) {
            for (int el : pm) {
                System.out.print(el + " ");
            }
            System.out.println();
        } else {
            for (int i = 1; i <= n; i++) {
                pm[level] = i;
                dfs(pm, n, m, level + 1);
            }
        }
    }
}
