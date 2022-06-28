import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 수열 추측하기
public class Main {
    static int n, f;
    static int[] arr, ch, p, b;
    static int[][] graph;
    boolean flag = false;

    private void DFS(int L, int sum) {
        if (flag) return;
        if (L == n) {
            if (sum == f) {
                for (int x : p) System.out.print(x + " ");
                System.out.println();
                flag = true;
            }
        } else {
            for (int i = 0; i < n; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    p[L] = arr[i];
                    DFS(L + 1, sum + (p[L] * b[L]));
                    ch[i] = 0;
                }
            }
        }
    }

    private int combi(int n, int r) {
        if (graph[n][r] > 0) return graph[n][r];
        if (n == r || r == 0) return 1;
        else {
            return graph[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        f = Integer.parseInt(st.nextToken());
        arr = new int[n]; // n이 주어졌을 때, 1 ~ n 까지 담아내는 변수
        p = new int[n]; // 순열을 구하기 위한 변수
        ch = new int[n + 1]; // 순열의 중복을 체크하기 위한 변수
        b = new int[n]; // 조합을 구하기 위한 변수
        graph = new int[n + 1][n + 1]; // 조합을 구할 때, 메모이제이션을 위한 변수
        for (int i = 0; i < n; i++) arr[i] = i + 1; // arr 초기화
        for (int i = 0; i < n; i++) b[i] = T.combi(n - 1, i); // combination 구해서 저장

        T.DFS(0, 0); // 순열 구하기
    }
}