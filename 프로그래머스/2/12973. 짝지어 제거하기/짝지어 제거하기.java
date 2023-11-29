import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(String s) {
        List<Character> list = new ArrayList<>();
        list.add(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (!list.isEmpty() && list.get(list.size() - 1) == s.charAt(i)) {
                list.remove(list.size() - 1);
                continue;
            }
            list.add(s.charAt(i));
        }
        return list.isEmpty() ? 1 : 0;
    }
}