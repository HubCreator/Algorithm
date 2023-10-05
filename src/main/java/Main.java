import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st1.nextToken());
        int K = Integer.parseInt(st1.nextToken());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        Queue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i < arr.length; i++) {
            pq.offer(arr[i] - arr[i - 1]);
        }

        int answer = 0;
        for (int i = 0; i < N - K; i++) {
            answer += pq.poll();
        }

        System.out.print(answer);
    }
}
