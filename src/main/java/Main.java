import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String line = br.readLine();
        String[] split = line.split(" ");
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for (String s : split) {
            if (s.endsWith("Cheese")) {
                set.add(s);
            }
        }

        if (set.size() >= 4) {
            System.out.println("yummy");
        } else {
            System.out.println("sad");
        }

    }
}
