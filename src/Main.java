import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 연속 부분 수열 구하기
public class Main {
    private int solution(int m, int[] arr) {
        int result = 0;
        int size = 2;
        while (size < arr.length) {
            for (int i = 0; i < arr.length - size; i++) {
                int count = 0;
                for (int j = i; j < i + size; j++) {
                    count += arr[j];
                }
                if (count == m) result++;
            }
            size++;
        }
        return result;
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