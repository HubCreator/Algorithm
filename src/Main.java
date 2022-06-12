import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private Character solution(int n, char[] chars) {
        Map<Character, Integer> answer = new HashMap<>();
        for (char aChar : chars) {
            answer.put(aChar, answer.getOrDefault(aChar, 0) + 1);
        }
        return Collections.max(answer.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] chars = br.readLine().toCharArray();

        System.out.println(T.solution(n, chars));
    }
}