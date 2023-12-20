import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int target = N, answer = 0;
        do {
            int tmp = target / 10 + target % 10;
            target = (target % 10) * 10 + (tmp % 10);
            answer++;
        } while (N != target);
        System.out.print(answer);
    }
}