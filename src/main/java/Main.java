import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String s = st.nextToken();
        char t = st.nextToken().toCharArray()[0];
        int[] result = new int[s.length()];
        Arrays.fill(result, 1000);

        int index = 1000;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t) {
                result[i] = 0;
                index = i;
            }
            if (result[i] > Math.abs(index - i)) {
                result[i] = Math.abs(index - i);
            }
        }

        index = 1000;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == t) {
                result[i] = 0;
                index = i;
            }
            if (result[i] > Math.abs(index - i)) {
                result[i] = Math.abs(index - i);
            }
        }

        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}