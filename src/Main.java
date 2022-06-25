import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 경로 탐색 (인접 행렬)
public class Main {
    static int n, m;
    static int[][] graph;
    static int[] check;
    static int answer = 0;

    private void DFS(int val) {
        if (val == n) {
            answer++;
        } else {
            for (int i = 1; i <= n; i++) {
                if (graph[val][i] == 1 && check[i] == 0) {
                    check[i] = 1;
                    DFS(i);
                    check[i] = 0;
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
        graph = new int[n + 1][n + 1];
        check = new int[n + 1];
        StringTokenizer[] stArr = new StringTokenizer[m + 1];
        for (int i = 1; i <= m; i++) {
            stArr[i] = new StringTokenizer(br.readLine(), " ");
            graph[Integer.parseInt(stArr[i].nextToken())][Integer.parseInt(stArr[i].nextToken())] = 1;
        }
        check[1] = 1;
        T.DFS(1);
        System.out.println(answer);
    }
}