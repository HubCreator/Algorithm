import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int c, n;
    static int[] arr, ch;
    static List<Integer> answer = new ArrayList<>();

    private void DFS(int L) {
        if (L == n + 1) {
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 1)
                    sum += arr[i];
            }
            if (sum < c) answer.add(sum);
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
        arr = new int[n + 1];
        ch = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        T.DFS(1);
        System.out.println(Collections.max(answer));
    }
}