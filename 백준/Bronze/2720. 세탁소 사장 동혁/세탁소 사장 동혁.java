import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static double[] money = new double[]{25, 10, 5, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            answer.append(solution(Integer.parseInt(br.readLine()))).append('\n');
        }

        System.out.print(answer);
    }

    private static String solution(int input) {
        int[] count = new int[money.length];
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < money.length; i++) {
            double t = input / money[i];
            if (t > 0) {
                count[i] += (int) t;
                input -= money[i] * (int) t;
            }
        }
        for (int c : count) {
            result.append(c).append(' ');
        }
        return result.deleteCharAt(result.length() - 1).toString();
    }
}