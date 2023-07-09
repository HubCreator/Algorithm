import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final int digitCount = 10, charCount = 26;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int[] digitArr = new int[input.length()];
        int[] charArr = new int[input.length()];

        if (input.charAt(0) == 'c') {
            charArr[0] = charCount;
        } else {
            digitArr[0] = digitCount;
        }

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == 'c') {
                if (charArr[i - 1] != 0) {
                    charArr[i] = charCount - 1;
                } else {
                    charArr[i] = charCount;
                }
            } else {
                if (digitArr[i - 1] != 0) {
                    digitArr[i] = digitCount - 1;
                } else {
                    digitArr[i] = digitCount;
                }
            }
        }

        int answer = 1;
        for (int i = 0; i < input.length(); i++) {
            if (charArr[i] != 0) {
                answer *= charArr[i];
            }
            if (digitArr[i] != 0) {
                answer *= digitArr[i];
            }
        }

        System.out.println(answer);
    }
}
