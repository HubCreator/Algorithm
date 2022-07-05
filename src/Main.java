import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] unf;

    int Find(int v) {
        if (v == unf[v]) return unf[v];
        else return unf[v] = Find(unf[v]);
    }

    private void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if (fa != fb) unf[fa] = fb;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        unf = new int[n + 1];
        for (int i = 1; i <= n; i++) unf[i] = i;
        for (int i = 1; i <= m; i++) {
            StringTokenizer tmp = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(tmp.nextToken());
            int b = Integer.parseInt(tmp.nextToken());
            T.Union(a, b);
        }
        StringTokenizer q = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(q.nextToken());
        int b = Integer.parseInt(q.nextToken());
        System.out.println(T.Find(a) == T.Find(b) ? "YES" : "NO");
    }
}