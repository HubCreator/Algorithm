import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static boolean answer = false;
    static int n, arrSum;
    static int[] arr, ch;

    private void DFS(int L) {
        if (L == n) {
            int sum = 0;
            for (int i = 0; i < ch.length; i++) if (ch[i] == 1) sum += arr[i];
            if(sum * 2 == arrSum) answer = true;
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
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        arr = new int[n];
        ch = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        arrSum = Arrays.stream(arr).sum();
        T.DFS(0);
        System.out.println(answer ? "YES" : "NO");
    }
}