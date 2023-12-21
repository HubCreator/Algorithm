import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st1.nextToken());
        int M = Integer.parseInt(st1.nextToken());
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int tmp;
            for (int j = from; j <= (from + to) / 2; j++) {
                tmp = arr[j];
                arr[j] = arr[(from + to) - j];
                arr[(from + to) - j] = tmp;
            }
        }
        StringBuilder answer = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            answer.append(arr[i]).append(' ');
        }
        System.out.print(answer);
    }
}