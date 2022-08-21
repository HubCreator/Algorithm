import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static private Integer[] arr;
    static private int m, answer = Integer.MAX_VALUE;

    private void dfs(int L, int sum) {
        if (sum > m || L >= answer) return;
        if (sum == m) answer = Math.min(answer, L);
        else {
            for (Integer x : arr) dfs(L + 1, sum + x);
        }
    }

    private int solution() {
        dfs(0, 0);

        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new Integer[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());

        Arrays.sort(arr, Collections.reverseOrder());

        System.out.println(T.solution());
    }
}