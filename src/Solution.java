import java.util.Stack;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (stack.isEmpty()) stack.push(c);
            else {
                if (c == '(') stack.push(c);
                else {
                    if (stack.peek() == '(') stack.pop();
                    else return false;
                }
            }
        }
        return stack.isEmpty();
    }
}