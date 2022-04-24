import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st1.nextToken());
        int K = Integer.parseInt(st1.nextToken());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st2.nextToken());

        int answer = 0;
        int sum = 0;
        for(int i = 0; i < K; i++) sum += arr[i]; // 초기 윈도우 만들기
        answer = sum;
        for(int i = K; i < N; i++) {
            sum = sum + arr[i] - arr[i-K];
            answer = Math.max(answer, sum);
        }

        System.out.println(answer);
    }
}