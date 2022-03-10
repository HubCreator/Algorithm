import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();

        for(char x : str.toCharArray()) {
            if(x == ')')
                while(stack.pop() != '('); // 조건을 실행하고, 만족시키지 않으면 break;
            else stack.push(x);
        }
        stack.forEach(System.out::print);
    }
}