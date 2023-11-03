import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class Main {
    private static StringBuilder answer = new StringBuilder();
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        int N = Integer.parseInt(st1.nextToken());
        int K = Integer.parseInt(st1.nextToken());

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        for (int i = 0; i < K; i++) {
            String[] split = br.readLine().split(" ");
            double result = solution(Integer.parseInt(split[0]) - 1, Integer.parseInt(split[1]) - 1);
            answer.append(decimalFormat.format(result)).append('\n');
        }

        System.out.println(answer);
    }

    public static double solution(int a, int b) {
        double sum = 0;
        for (int i = a; i <= b; i++) {
            sum += arr[i];
        }
        return sum / (b - a + 1);
    }
}
