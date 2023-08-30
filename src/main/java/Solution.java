import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(String s) {
        List<Character> list = new ArrayList<>();
        list.add(list.get(0));
        for (int i = 1; i < s.length(); i++) {
            if (!list.isEmpty() && list.size() > 0 && list.get(list.size() - 1) == s.charAt(i)) {
                list.remove(list.size() - 1);
                continue;
            }
            list.add(s.charAt(i));
        }

        return list.isEmpty() ? 1 : 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("baabaa"));
    }
}
