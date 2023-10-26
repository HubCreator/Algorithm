import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        char[] wolf = new char[]{'w', 'o', 'l', 'f'};
        line += '!';
        Map<Character, Integer> map = new LinkedHashMap<>();

        char cur = 'w';
        if (!line.startsWith("w")) {
            System.out.println(0);
            return;
        }
        int index = 0;
        for (int i = 0; i < line.length() - 1; i++) {
            char c = line.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (c != cur) {
                cur = c;
                index++;
                if (wolf[index % 4] != c) {
                    System.out.println(0);
                    return;
                }
            }

            if (c == 'f' && line.charAt(i + 1) == 'w') {
                if (!isValid(map)) {
                    System.out.println(0);
                    return;
                }
                map.clear();
            }
        }

        if (!isValid(map)) {
            System.out.println(0);
            return;
        }
        System.out.println(1);
    }

    private static boolean isValid(Map<Character, Integer> map) {
        int sum = getSum(map);
        StringBuilder sb = new StringBuilder();
        for (Character character : map.keySet()) {
            sb.append(character);
        }

        return sum % 4 == 0 && map.size() % 4 == 0 && sb.toString().equals("wolf");
    }

    private static int getSum(Map<Character, Integer> map) {
        int sum = 0;
        for (Integer value : map.values()) {
            sum += value;
        }
        return sum;
    }
}
