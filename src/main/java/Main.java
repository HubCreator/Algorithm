import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(T.factorial(n));
    }

    private int factorial(int n) {
        if (n == 1) { // 기저 조건
            return 1;
        } else {
            return n * factorial(n - 1); // 값을 누적시킴
        }
    }
}
