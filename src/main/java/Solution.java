import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            String str = br.readLine();
            answer.append("#" + test_case + " " + solution(str) + "\n");
        }
        System.out.println(answer);
    }

    private static int solution(String str) {
        char[] chars = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        int result = 0;

        boolean flag = false;
        for (char ch : chars) {
            if (flag) {
                if (ch == ')' || ch == '|') result++;
                flag = false;
            } else if (ch == '(') flag = true;
            else if (ch == ')' && (stack.peek() == '|' || stack.peek() == '(')) {
                result++;
            }
            stack.push(ch);
        }
        return result;
    }
}
