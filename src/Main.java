import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 괄호 문자 제거
public class Main {
    private List<Character> solution(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            Character pop;
            if (str.charAt(i) != ')')
                stack.push(str.charAt(i));
            else
                do {
                    pop = stack.pop();
                } while (pop != '(');
        }
        return new ArrayList<>(stack);
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        for (Character x : T.solution(str)) {
            System.out.print(x);
        }
    }
}