import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        boolean[] check = new boolean[N];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 4; i++) {
            int result = 1;
            for (int j = i; j < N - 3 + i; j++) {
                result *= arr[j];
                check[j] = true;
            }
            for (int j = 0; j < N; j++) {
                if (!check[j]) {
                    result += arr[j];
                }
            }
            if (result > max) {
                max = result;
            }
            Arrays.fill(check, false);
        }
        System.out.println(max);
    }
}
