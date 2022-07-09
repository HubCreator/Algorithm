import java.util.Stack;

class Solution {
    public int solution(int n) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder ternary = new StringBuilder();

        do {
            stack.push(n % 3);
            n = n / 3;
        } while (n > 0);
        while (!stack.isEmpty()) ternary.append(stack.pop()); // 10진법을 3진법으로

        ternary.reverse(); // 뒤집기

        return Integer.parseInt(ternary.toString(), 3); // 3진법을 10진법으로
    }
}