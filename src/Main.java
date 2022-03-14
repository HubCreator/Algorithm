import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tmp = br.readLine();
        Stack<Character> stack = new Stack<>();
        int answer = 0;

        for(int i = 0; i < tmp.length(); i++) {
            if(tmp.charAt(i) == '(') stack.push('(');
            else {
                stack.pop();
                if(tmp.charAt(i-1) == '(') answer += stack.size(); // 원본과의 비교
                else answer++;
            }
        }

        System.out.println(answer);
    }
}