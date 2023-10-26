import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static String wolf = "wolf";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        line += '!';
        List<String> list = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < line.length() - 1; i++) {
            sb.append(line.charAt(i));
            if (line.charAt(i) == 'f' && line.charAt(i + 1) == 'w') {
                list.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        list.add(sb.toString());

        for (String s : list) {
            int n = s.length() / 4;
            if (!s.equals(makeString(n))) {
                System.out.println(0);
                return;
            }
        }
        System.out.println(1);
    }

    private static String makeString(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < wolf.length(); i++) {
            for (int j = 0; j < n; j++) {
                sb.append(wolf.charAt(i));
            }
        }
        return sb.toString();
    }
}
