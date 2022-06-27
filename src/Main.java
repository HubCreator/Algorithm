import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

// 거스름 돈 걸러주기
public class Main {
    static int n, m;
    static int answer = Integer.MAX_VALUE;
    static Integer[] arr;
    static int[] ch;

    private void DFS(int L, int sum) {
        if(sum > m || L >= answer) return;
        if (sum == m) {
            answer = Math.min(answer, L);
        } else {
            for (int i = 0; i < n; i++) {
                DFS(L + 1, sum + arr[i]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        arr = new Integer[n];
        ch = new int[n + 1];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr, Collections.reverseOrder());
        m = Integer.parseInt(br.readLine());
        T.DFS(0, 0);
        System.out.println(answer);
    }
}