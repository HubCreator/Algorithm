import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] check = new boolean[n];
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        boolean answer = T.dfs(arr, check, 0, 0, 0);
        System.out.println(answer);
    }

    private boolean dfs(int[] arr, boolean[] check, int level, int sum1, int sum2) {
        if (level == arr.length) {
            return sum1 == sum2;
        } else {
            // 조기 종료 방법
            // 만약 각 조건이 true이면 상위로 true를 계속 던저 조기 종료시킴
            // 만약 각 조건이 false이면 그 다음 로직을 이어나감
            if (dfs(arr, check, level + 1, sum1 + arr[level], sum2)) {
                return true;
            }
            if (dfs(arr, check, level + 1, sum1, sum2 + arr[level])) {
                return true;
            }
            return false;
        }
    }
}
