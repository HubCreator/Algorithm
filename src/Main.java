import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] arr, pm, ch;

    private void DFS(int L) {
        if (L == m) {
            for (int x : pm) System.out.print(arr[x] + " ");
            System.out.println();
        } else {
            for (int i = 0; i < n; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    pm[L] = i;
                    DFS(L + 1);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        ch = new int[n];
        pm = new int[m];
        StringTokenizer tmp = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(tmp.nextToken());
        T.DFS(0);
    }
}