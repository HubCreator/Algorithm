import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int c, n, answer = Integer.MIN_VALUE;
    static int[] arr, ch;

    private void DFS(int L) {
        if (L == n) {
            int sum = 0;
            for (int i = 0; i < ch.length; i++) {
                if (ch[i] == 1) sum += arr[i];
            }
            if (sum <= c) answer = Math.max(answer, sum);
        } else {
            ch[L] = 1;
            DFS(L + 1);
            ch[L] = 0;
            DFS(L + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        ch = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(br.readLine());
        T.DFS(0);
        System.out.println(answer);
    }
}