import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int count(int[] arr, int capacity) {
        int cnt = 1, sum = 0; // cnt는 DVD 장수
        for(int x : arr) {
            if(sum + x > capacity) {
                cnt++;
                sum = x;
            } else sum += x;
        }
        return cnt;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st1.nextToken());
        int M = Integer.parseInt(st1.nextToken());
        int[] arr = new int[N];

        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st2.nextToken());

        int answer = 0;
        int lt = Arrays.stream(arr).max().getAsInt(),
                rt = Arrays.stream(arr).sum();

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if(count(arr, mid) <= M) {
                answer = mid;
                rt = mid - 1;
            } else lt = mid + 1;
        }

        System.out.print(answer);
    }
}