import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] ch;

    private void DFS(int L) {
        if (L == m) {
            for (int x : ch) System.out.print(x + " ");
            System.out.println();

        } else {
            for (int i = 1; i <= n; i++) { // 1부터 시작해서 n까지 돌아야 하니까
                ch[L] = i; // L은 0부터 인덱스의 숫자와 함께 올라감
                DFS(L + 1);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ch = new int[m];

        T.DFS(0);

    }
}