import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static StringBuilder answer = new StringBuilder();
    static StringBuilder buf;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            answer.append(calculator(i) + " ");
        }
        System.out.println(answer);
    }

    public static String calculator(int n) {
        int cnt = 0;
        int num = n;
        buf = new StringBuilder();
        while (num > 0) {
            int t = num % 10;
            num /= 10;
            if (t > 0 && t % 3 == 0) {
                cnt++;
                buf.append('-');
            }
        }
        return (cnt == 0) ? (n + "") : buf.toString();
    }
}