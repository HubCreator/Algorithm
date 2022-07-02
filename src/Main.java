import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    int sum(int n) {
        return n * (n + 1) / 2;
    }

    private int solution(int n) {
        int answer = 0;
        for (int i = 2; i < n; i++) {
            if (n < sum(i)) break;
            if ((n - sum(i)) % i == 0) answer++;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(T.solution(n));
    }
}