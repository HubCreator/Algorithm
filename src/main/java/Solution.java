import java.util.Stack;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (stack.isEmpty() || c == '(') {
                stack.push(c);
                continue;
            }
            if (stack.peek() == '(') {
                stack.pop();
                continue;
            }
            return false;
        }
        return stack.isEmpty();
    }
}