import java.util.Stack;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        for(int x : arr) {
            if(stack.isEmpty()) stack.push(x);
            else if(!stack.isEmpty() && stack.peek() != x) {
                stack.push(x);
            }
        }
        return stack.stream().mapToInt(Integer::intValue).toArray();
    }
}