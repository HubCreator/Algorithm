import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            answer.append("Case #").append(i + 1).append(": ").append(solution(n)).append('\n');
        }
        System.out.println(answer);
    }

    private static String solution(int n) {
        if (n == 0) {
            return "INSOMNIA";
        }
        Map<Character, Integer> map = new HashMap<>();
        int multiply = 1;
        while (map.size() < 10) {
            char[] charArray = String.valueOf(n * multiply).toCharArray();
            for (char c : charArray) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            multiply++;
        }
        return String.valueOf(n * (multiply - 1));
    }
}
