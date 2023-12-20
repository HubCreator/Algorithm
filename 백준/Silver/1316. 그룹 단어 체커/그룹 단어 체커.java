import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            solution(line);
        }
        System.out.print(answer);
    }

    private static void solution(String line) {
        char[] chars = line.toCharArray();
        boolean flag = true;
        List<Character> stack = new ArrayList<>();
        stack.add(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            char target = chars[i];
            if (stack.contains(target) && stack.get(stack.size() - 1) != target) {
                flag = false;
                break;
            }
            stack.add(target);
        }
        if (flag) {
            answer++;
        }
    }
}