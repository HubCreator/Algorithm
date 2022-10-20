import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public String solution(String number, int k) {
        char[] result = new char[number.length() - k];
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                stack.pop();
            }
            stack.push(c);
        }

        for (int i = 0; i < result.length; i++) {
            result[i] = stack.pollLast();
        }
        return new String(result);
    }
}