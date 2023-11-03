import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long s = Long.parseLong(br.readLine());
        long sum = 0, count = 1;
        while (sum + count <= s) {
            sum += count;
            count++;
        }

        System.out.println(count - 1);
    }
}
