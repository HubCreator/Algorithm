import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = initArr(N);
        for (int i = 0; i < K; i++) {
            int index = Integer.parseInt(br.readLine());
            arr[index] = 0;
        }

        int answer = Integer.MAX_VALUE, brokenCount = 0;
        for (int i = 0; i < B - 1; i++) {
            if (arr[i] == 0) {
                brokenCount++;
            }
        }

        for (int i = B - 1; i < arr.length; i++) {
            if (arr[i] == 0) {
                brokenCount++;
            }
            answer = Math.min(answer, brokenCount);
            if (arr[i - (B - 1)] == 0) {
                brokenCount--;
            }
        }

        System.out.print(answer);
    }

    private static int[] initArr(int N) {
        int[] arr = new int[N + 1];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = i;
        }
        return arr;
    }
}
