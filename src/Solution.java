import java.util.List;
import java.util.Stack;

class Solution {
    List<Character> lt = List.of('(', '{', '[');
    List<Character> rt = List.of(')', '}', ']');
    Stack<Character> stack = new Stack<>();

    public boolean check(String s) {
        stack.clear();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty() || lt.contains(c)) stack.push(c);
            else {
                if (rt.contains(c) && lt.indexOf(stack.peek()) == rt.indexOf(c)) stack.pop();
                else break;
            }
        }
        return stack.isEmpty();
    }

    public int solution(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            answer += check(s) ? 1 : 0;
            s = s.substring(1).concat(s.substring(0, 1));
        }
        return answer;
    }
}