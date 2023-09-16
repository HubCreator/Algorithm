import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String result = br.readLine().strip();
        if (result.isEmpty()) {
            System.out.println(0);
            return;
        }
        int answer = 1;
        char[] charArray = result.toCharArray();
        for (int i = 0; i < charArray.length - 1; i++) {
            if (charArray[i] == ' ' && charArray[i + 1] != ' ') {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
