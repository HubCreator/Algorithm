import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();
        List<Character> list = List.of('#', '!', '*', '@');
        int length = chars.length;
        for (int i = 0; i < length / 2; i++) {
            if (!list.contains(chars[i])) {
                char tmp = chars[i];
                chars[i] = chars[length - 1 - i];
                chars[length - 1 - i] = tmp;
            }
        }
        for (Character character : chars) {
            System.out.print(character);
        }
    }
}