import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private String solution(String str) {
        StringBuilder sb = new StringBuilder();
        int sum = 1;
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) sum++;
            else {
                if (sum > 1) {
                    sb.append(sum);
                    sb.append(str.charAt(i));
                    sum = 1;
                } else sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine() + " ";
        System.out.println(T.solution(str));;
    }
}