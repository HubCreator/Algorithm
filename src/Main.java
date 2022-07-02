import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private int solution(int n, int k, int[] arr) {
        int answer = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < k - 1; i++) sum += arr[i]; // 초기 윈도우값 설정
        for (int i = k - 1; i < n - k + 1; i++) {
            sum += arr[i];
            answer = Math.max(answer, sum);
            sum -= arr[i - (k - 1)];
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st1.nextToken());
        int k = Integer.parseInt(st1.nextToken());
        int[] arr = new int[n];
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st2.nextToken());
        System.out.println(T.solution(n, k, arr));
    }
}