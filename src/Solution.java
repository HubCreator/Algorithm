import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> list = new ArrayList<>();

    void dfs(String str, int len) {
        if (len > 5) return;
        list.add(str);
        for (int i = 0; i < 5; i++) dfs(str + "AEIOU".charAt(i), len + 1);
    }

    public int solution(String word) {
        dfs("", 0);
        return list.indexOf(word);
    }
}