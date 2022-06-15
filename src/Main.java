import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 쇠 막대기 커팅
public class Main {
    private int solution(char[] chars) {
        int answer = 0, pt = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length - 1; i++) {
            char lt = chars[i];
            char rt = chars[i + 1];
            if (lt == '(') {
                stack.push(lt);
                if (rt == ')') {
                    stack.pop();
                    answer += stack.size();
                    pt = i + 1;
                }
            } else { // lt == ')'
                if (i == pt) continue;
                stack.pop();
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine() + " ";
        System.out.println(T.solution(str.toCharArray()));
    }
}