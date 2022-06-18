import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 재귀 -> 피보나치
public class Main {
    private int recursive(int n) {
        if (n == 0 || n == 1) return 1;
        else if (n == 2) return 2;
        else return recursive(n - 2) + recursive(n - 1);
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            System.out.print(T.recursive(i) + " ");
        }
    }
}