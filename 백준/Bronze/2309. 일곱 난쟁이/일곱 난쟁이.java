import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static int[] result = new int[]{};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int[] arr = new int[9];
        boolean[] check = new boolean[9];
        int[] pm = new int[7];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dfs(arr, check, pm, 0, 0);
        Arrays.sort(result);
        for (int r : result) {
            answer.append(r).append('\n');
        }
        System.out.print(answer);
    }

    private static void dfs(int[] arr, boolean[] check, int[] pm, int sum, int level) {
        if (level == pm.length) {
            if (sum == 100) {
                int[] tmp = new int[pm.length];
                for (int i = 0; i < pm.length; i++) {
                    tmp[i] = arr[pm[i]];
                }
                result = tmp;
            }
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (!check[i]) {
                    check[i] = true;
                    pm[level] = i;
                    dfs(arr, check, pm, sum + arr[i], level + 1);
                    check[i] = false;
                }
            }
        }
    }
}