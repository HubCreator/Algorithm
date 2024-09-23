import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = {300, 60, 10};
        int[] answer = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int t = arr[i];
            if (n >= t) {
                int divide = n / t;
                answer[i] += divide;
                n -= divide * t;
            }
        }

        if (n == 0) {
            for (int i : answer) {
                System.out.print(i + " ");
            }
        } else {
            System.out.print(-1);
        }

    }
}
