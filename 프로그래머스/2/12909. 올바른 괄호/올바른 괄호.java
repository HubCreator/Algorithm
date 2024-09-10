import java.util.*;

class Solution {
    boolean solution(String s) {
        List<Character> stack = new ArrayList<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.add(s.charAt(i));    
                continue;
            } 
            
            char top = stack.get(stack.size() - 1);
            if (top == ')') {
                return false;
            } else { // '('
                if (s.charAt(i) == '(') {
                    stack.add(s.charAt(i));
                } else {
                    stack.remove(stack.size() - 1);
                }
            }
        }
        
        return stack.size() == 0;
    }
}