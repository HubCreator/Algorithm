import java.util.Stack;

class Solution {
    public String solution(String str) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char t = str.charAt(i);
            if (Character.isAlphabetic(t) | t == '(') stack.push(t);
            else {
                Character pop;
                do {
                    pop = stack.pop();
                } while (pop != '(');
            }
        }
        while (!stack.isEmpty()) sb.append(stack.pop());

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        String tmp = "(A(BC)D)EF(G(H)(IJ)K)LM(N)";
        System.out.println(T.solution(tmp));
    }
}