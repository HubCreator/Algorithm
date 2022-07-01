import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private int[] solution(String str, char c) {
        int[] answer = new int[str.length()];
        Arrays.fill(answer, 10000);

        int index = 10000;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                index = i;
                answer[i] = 0;
            } else {
                answer[i] = Math.abs(index - i);
            }
        }

        index = 10000;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == c) {
                index = i;
                answer[i] = 0;
            } else {
                answer[i] = Math.min(Math.abs(index - i), answer[i]);
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String str = st.nextToken();
        char c = st.nextToken().toCharArray()[0];
        for (int x : T.solution(str, c)) System.out.print(x + " ");
    }
}