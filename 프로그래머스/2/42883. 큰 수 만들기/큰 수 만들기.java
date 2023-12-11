import java.util.ArrayList;
import java.util.List;

class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int n = number.length();
        int t = n - k;  // 스택에 들어갈 숫자 개수
        List<Character> stack = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            char current = number.charAt(i);
            while (k > 0 && !stack.isEmpty() && stack.get(stack.size() - 1) < current) {
                stack.remove(stack.size() - 1);  // 스택에서 더 작은 숫자 제거
                k--;
            }
            stack.add(current);  // 현재 숫자 스택에 추가
        }

        // 남은 숫자를 스택에서 가져와서 문자열로 결합
        for (int i = 0; i < t; i++) {
            answer.append(stack.get(i));
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("1924", 2));  // "94" 출력
    }
}
