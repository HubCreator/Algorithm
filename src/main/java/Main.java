import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] s = br.readLine().toCharArray();
        String k = br.readLine();
        StringBuilder realS = new StringBuilder();
        for (char c : s) {
            if (Character.isAlphabetic(c)) {
                realS.append(c);
            }
        }
        if (realS.toString().contains(k)) {
            System.out.println(1);
            return;
        }
        System.out.println(0);
    }
}
