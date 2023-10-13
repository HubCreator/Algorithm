import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int size = N - 4 + 1;
        int max = Integer.MIN_VALUE, multiply = 1;
        boolean[] check = new boolean[N];

        for (int i = 0; i < size - 1; i++) {
            multiply *= arr[i];
            check[i] = true;
        }

        for (int i = size - 1; i < N; i++) {
            multiply *= arr[i];
            check[i] = true;
            int sum = 0;
            for (int j = 0; j < arr.length; j++) {
                if (!check[j]) {
                    sum += arr[j];
                }
            }
            max = Math.max(max, multiply + sum);
            multiply /= arr[i - size + 1];
            check[i - size + 1] = false;
        }

        System.out.print(max);
    }
}
