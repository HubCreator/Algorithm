import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int[] increaseDP = new int[N];
        int[] decreaseDP = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            increaseDP[i] = 1;
            decreaseDP[i] = 1;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    increaseDP[i] = Math.max(increaseDP[i], increaseDP[j] + 1);
                }
            }
        }

        for (int i = N - 1; i >= 0; i--) {
            for (int j = N - 1; j >= i; j--) {
                if (arr[j] < arr[i]) {
                    decreaseDP[i] = Math.max(decreaseDP[i], decreaseDP[j] + 1);
                }
            }
        }

        for (int i = 0; i < increaseDP.length; i++) {
            increaseDP[i] += decreaseDP[i] - 1;
        }

        int result = Arrays.stream(increaseDP)
                .max()
                .getAsInt();
        
        System.out.print(result);
    }
}