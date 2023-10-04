import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < S.length(); i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = i; j < S.length(); j++) {
                list.add(S.charAt(j) - '0');
                if ((j - i + 1) % 2 != 0) {
                    continue;
                }
                int sum1 = 0, sum2 = 0;
                for (int k = 0; k < list.size() / 2; k++) {
                    sum1 += list.get(k);
                    sum2 += list.get(list.size() - 1 - k);
                }
                if (sum1 == sum2) {
                    answer = Math.max(answer, j - i + 1);
                }
            }
        }
        System.out.print(answer);
    }

    private static int sum(String S) {
        int result = 0;
        for (int i = 0; i < S.length(); i++) {
            result += S.charAt(i) - '0';
        }
        return result;
    }
}
