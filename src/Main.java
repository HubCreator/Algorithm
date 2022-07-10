import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int n, answer = 0;
    static int[] ch;

    private void DFS(int val) {
        if (val == n) {
            answer++;
        } else {
            for (Integer x : graph.get(val)) {
                if (ch[x] == 0) {
                    ch[x] = 1;
                    DFS(x);
                    ch[x] = 0;
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
        for (int i = 1; i <= n; i++) graph.add(new ArrayList<>());
        ch = new int[n + 1];
        for (int i = 0; i < m; i++) {
            StringTokenizer tmp = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(tmp.nextToken());
            int to = Integer.parseInt(tmp.nextToken());
            graph.get(from).add(to);
        }
        ch[1] = 1;
        T.DFS(1);
        System.out.println(answer);
    }
}