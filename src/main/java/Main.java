import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int result = 0;

        for (int i = 2; i <= n; i++) {
            if (arr[i] == 0) {
                result++;
                for (int j = i * 2; j <= n; j += i) {
                    arr[j] = 1;
                }
            }
        }


        for (int i = 2; i < arr.length; i++) {
            if (arr[i] == 0) {
                System.out.println(i);
            }
        }

        System.out.println(result);
    }
}
