import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        T.solution(n);
        System.out.println(answer);
    }

    static int cnt = 0, answer = 0;

    private int solution(int n) {
        // 기저 조건
        if (n < 2) {
            answer += (n % 2) * (int) Math.pow(10, cnt++);
            return n;
        }
        answer += (n % 2) * (int) Math.pow(10, cnt++);
        return solution(n / 2);
    }
}
