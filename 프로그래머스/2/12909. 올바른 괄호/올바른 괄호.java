import java.util.List;
import java.util.ArrayList;

class Solution {
    boolean solution(String s) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char target = s.charAt(i);
            if (list.isEmpty()) {
                list.add(target);
                continue;
            }
            char peek = list.get(list.size() - 1);
            if (peek == '(' && target == ')') {
                list.remove(list.size() - 1);
            } else {
                list.add(target);
            }
        }

        return list.isEmpty();
    }
}