import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// n일 중에서 k일 동안의 매출액 중 가장 높은 매출액
public class Main {
    public int solution(int n, int k, int[] arr) {
        int max = 0;
        int target = 0;
        for (int i = 0; i < n - k; i++) {
            for (int j = i; j < i + k; j++) {
                target += arr[j];
            }
            max = Math.max(max, target);
            target = 0;
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st1.nextToken());
        int k = Integer.parseInt(st1.nextToken());
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }
        System.out.println(T.solution(n, k, arr));;
    }
}