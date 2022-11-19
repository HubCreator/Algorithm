import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static StringBuilder answer = new StringBuilder();
    static StringTokenizer st;
    static int N, K, count = 0;
    static int[] arr, pm;
    static boolean[] check;
    static boolean[][] cache;

    private static void dfs(int L) {
        if (L == pm.length) {
            int sum = 0;
            for (int x : pm) sum += arr[x];
            if (sum == K) count++;
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!check[i]) {
                check[i] = true;
                pm[L] = i;
                dfs(L + 1);
                check[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            initialize(br);
            for (int i = 1; i <= N; i++) {
                pm = new int[i];
                check = new boolean[N];
                dfs(0);
            }
            answer.append("#" + test_case + " " + count / 2 + "\n");
        }
        System.out.println(answer);
    }

    private static void initialize(BufferedReader br) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        cache = new boolean[N][N];
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}