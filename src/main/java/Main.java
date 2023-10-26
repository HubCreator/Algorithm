import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
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

        String wolf = "wolf";
        char prev = '1';
        int idx = 0;
        for (String s : list) {
            int n = s.length() / 4;
            for (int i = 0; i < s.length(); i++) {
                char curr = s.charAt(i);
                if (i == 0) {
                    prev = curr;
                }

                if (prev != curr) {
                    if (wolf.charAt((idx + 1) % 4) == curr) {
                        idx++;
                        prev = curr;
                    } else {
                        System.out.println(0);
                        return;
                    }
                }

                if (s.lastIndexOf(curr) - s.indexOf(curr) + 1 != n) {
                    System.out.println(0);
                    return;
                }
            }
            idx = 0;
        }

        System.out.println(1);
    }
}
