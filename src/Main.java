import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] unf;
    private int find(int a) {
        if(unf[a] == a) return unf[a];
        else return unf[a] = find(unf[a]);
    }

    private void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if(fa != fb) unf[fa] = fb;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        unf = new int[n + 1];
        for (int i = 1; i <= n; i++) unf[i] = i;
        for (int i = 0; i < m; i++) {
            StringTokenizer tmp = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(tmp.nextToken());
            int b = Integer.parseInt(tmp.nextToken());
            T.union(a, b);
        }
        StringTokenizer q = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(q.nextToken());
        int b = Integer.parseInt(q.nextToken());
        System.out.println(T.find(a) == T.find(b) ? "YES" : "NO");
    }
}