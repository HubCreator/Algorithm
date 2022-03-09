import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < str.length(); i++) {
            char x = str.charAt(i);
            if (x == '(') stack.push(x);
            else if (x == ')') {
                int j = i-1;
                while(stack.peek() != '(') {
                    if(!stack.isEmpty())
                        stack.pop();
                    j = j-1;
                }
                if(!stack.isEmpty())
                    stack.pop();
            }
            else
                stack.push(x);
        }
        stack.forEach(System.out::print);
    }
}