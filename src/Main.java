import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 조합수 메모이제이션
public class Main {
    static int[][] ch;
    static int sum = 0;

    private void DFS(int n, int r) {
        if (ch[n][r] > 0) {
            sum += ch[n][r];
            return;
        }
        if (n == r){
            ch[n][r] = 1;
            sum += ch[n][r];
        } else if (r == 1) {
            ch[n][r] = n;
            sum += ch[n][r];
        } else {
            DFS(n - 1, r - 1);
            DFS(n - 1, r);
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        ch = new int[n + 1][n + 1];
        T.DFS(n, r);
        System.out.println(sum);
    }
}