import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int count = N, index = 0;
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }
        while (count > 1) {
            if (count < K) {
                System.out.print(arr[index]);
                return;
            }
            int size = K - 1;
            index = (index + 1) % N;
            while (size > 0) {
                if (arr[index] == -1) {
                    index = (index + 1) % N;
                    continue;
                }
                arr[index] = -1;
                count--;
                size--;
                index = (index + 1) % N;
            }

            while (arr[index] == -1) {
                index = (index + 1) % N;
            }
        }

        System.out.print(arr[index]);
    }
}