import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] graph;
    static int n, answer = 0;
    static int[] ch;

    private void DFS(int val) {
        if (val == n) {
            answer++;
        } else {
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 0 && graph[val][i] == 1) {
                    ch[i] = 1;
                    DFS(i);
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
        int m = Integer.parseInt(st.nextToken());
        graph = new int[n + 1][n + 1];
        ch = new int[n + 1];
        for (int i = 0; i < m; i++) {
            StringTokenizer tmp = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(tmp.nextToken());
            int to = Integer.parseInt(tmp.nextToken());
            graph[from][to] = 1;
        }
        ch[1] = 1;
        T.DFS(1);
        System.out.println(answer);
    }
}