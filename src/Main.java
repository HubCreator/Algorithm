import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 연속된 자연수의 합
public class Main {
    private int solution(int n) {
        int answer = 0, cnt = 1;
        n--; // 1을 뺌
        while (n > 0) {
            cnt++;
            n = n - cnt; // 2를 뺀 이후에 하나씩 loop를 돌며 뺌
            if (n % cnt == 0) answer++; // cnt는 size와 같음
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