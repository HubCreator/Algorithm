import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        long[] arr = new long[K];
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        long lt = 0, rt = Arrays.stream(arr).max().getAsLong() + 1, mid = 0;
        while (lt < rt) {
            mid = (lt + rt) / 2;
            long count = check(mid, arr);
            if (count < N) {
                rt = mid;
            } else {
                lt = mid + 1;
            }
        }
        System.out.print(lt - 1);
    }

    private static long check(long mid, long[] arr) {
        long result = 0;
        for (long el : arr) {
            result += el / mid;
        }
        return result;
    }
}