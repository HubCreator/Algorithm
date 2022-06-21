import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 합이 같은 부분집합 (DFS)
public class Main {
    static int arr[];
    static int max;
    static int n;
    static int ch[];
    static boolean answer = false;

    private int DFS(int L) {
        if (L == n + 1) { // 깊이가 하나 더 초과한다면..
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 1) {
                    sum += arr[i];
                }
            }
            if (sum * 2 == max) {
                answer = true;
                return 1;
            }
        } else {
            ch[L] = 1;
            DFS(L + 1);
            ch[L] = 0;
            DFS(L + 1);
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        arr = new int[n + 1];
        max = Arrays.stream(arr).max().getAsInt();
        for (int i = 1; i <= arr.length - 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        ch = new int[n + 1];
        T.DFS(1);

        if (answer) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}