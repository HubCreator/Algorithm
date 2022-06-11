import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 연속 부분 수열 구하기
public class Main {
    public int solution(int m, int[] arr) {
        int answer = 0, sum = 0, lt = 0;
        for (int rt = 0; rt < arr.length; rt++) {
            sum += arr[rt];
            if (sum == m) answer++;
            while (sum >= m) {
                sum -= arr[lt++];
                if (sum == m) answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }
        System.out.println(T.solution(m, arr));
    }
}