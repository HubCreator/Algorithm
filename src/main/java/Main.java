import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            int[] pm = new int[i];
            boolean[] check = new boolean[N];
            dfs(i, arr, pm, check, 0);
        }

        System.out.print(answer);
    }

    private static void dfs(int len, int[] arr, int[] pm, boolean[] check, int level) {
        if (len == level) {
            boolean flag = true;
            for (int i = 0; i < pm.length - 1; i++) {
                if (pm[i] >= pm[i + 1]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                answer = Math.max(answer, len);
            }
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (!check[i]) {
                    check[i] = true;
                    pm[level] = arr[i];
                    dfs(len, arr, pm, check, level + 1);
                    check[i] = false;
                }
            }
        }
    }
}