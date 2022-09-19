import java.util.Stack;

class Solution {
    public int[] solution(int n, String[] words) {
        int who = 0, turn = 0, idx = 0;
        Stack<String> stack = new Stack<>();

        for (String word : words) {
            if (idx % n == 0) turn++;
            if (stack.isEmpty()) stack.push(word);
            else if (!stack.contains(word)) {
                String peek = stack.peek();
                if (peek.charAt(peek.length() - 1) == word.charAt(0)) stack.push(word);
                else break;
            } else break;
            who = (who + 1) % n;
            idx++;
        }

        if (stack.size() == words.length) return new int[]{0, 0};
        else return new int[]{who + 1, turn};
    }
}