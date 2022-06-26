import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr, ch;
    static int n, answer;
    static boolean flag = false;

    private void DFS(int L) {
        if (L == n + 1) {
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                if (ch[i] == 1) sum += arr[i];
            }
            if (sum == answer) flag = true;
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
        arr = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        ch = new int[n + 1];
        answer = Arrays.stream(arr).sum() / 2;
        T.DFS(1);
        if (flag)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}