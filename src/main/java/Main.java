import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            answer.append(solution(n)).append('\n');
        }
        System.out.print(answer);
    }

    private static int solution(int n) {
        int answer = 1;
        for (int a = 0; ; a++) {
            for (int b = 0; ; b++) {
                int next = (2 * a) + (3 * b);
                if (next == 0 || next > n ||
                        (a > 0 && b > 0) && next % 2 == 0 ||
                        (a > 0 && b > 0) && next % 3 == 0) {
                    break;
                }
                answer += n / next;
            }
            if (n < 2 * a) {
                break;
            }
        }

        return answer;
    }
}
