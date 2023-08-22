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
        boolean[] check = new boolean[n];

        T.dfs(check, m, 0, 0);
    }

    private void dfs(boolean[] check, int m, int count, int level) {
        if (level == m + 1) {
            if (count == m) {
                for (int i = 0; i < check.length; i++) {
                    if (check[i]) {
                        System.out.print(i + 1 + " ");
                    }
                }
                System.out.println();
            }
        } else {
            check[level] = true;
            dfs(check, m, count + 1, level + 1);
            check[level] = false;
            dfs(check, m, count, level + 1);
        }
    }
}
