import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // 500엔, 100엔, 50엔, 10엔, 5엔, 1
        int[] money = {500, 100, 50, 10, 5, 1};
        int answer = 0, count;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 1000 - Integer.parseInt(br.readLine());

        for (int t : money) {
            if (t > n) {
                continue;
            }
            count = n / t;
            answer += count;
            n -= count * t;
        }
        System.out.print(answer);
    }
}
