import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    private boolean solution(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(')
                stack.push(str.charAt(i));
            else {
                if(stack.size() == 0) return false;
                if(stack.pop() != '(') return false;
            }
        }
        return stack.size() == 0;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(T.solution(str) ? "YES" : "NO");
    }
}