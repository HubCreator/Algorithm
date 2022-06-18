import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private char[] solution(char[] chars) {
        for (int i = 0; i < chars.length / 2; i++) {
            char tmp;
            if (Character.isAlphabetic(chars[i])) {
                tmp = chars[i];
                chars[i] = chars[chars.length - 1 - i];
                chars[chars.length - 1 - i] = tmp;
            }
        }
        return chars;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(br.readLine());
        System.out.println(T.solution(sb.toString().toCharArray()));
    }
}