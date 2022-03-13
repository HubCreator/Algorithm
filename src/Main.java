import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tmp = br.readLine();
        Stack<Integer> stack = new Stack<>();

        for(char x : tmp.toCharArray()) {
            if(Character.isDigit(x)) stack.push(Integer.parseInt(String.valueOf(x)));
            else {
                int rt = stack.pop();
                int lt = stack.pop();
                switch (x) {
                    case '+': stack.push(lt + rt); break;
                    case '-': stack.push(lt - rt); break;
                    case '*': stack.push(lt * rt); break;
                    case '/': stack.push(lt / rt); break;
                }
            }
        }

        System.out.println(stack.peek());
    }
}