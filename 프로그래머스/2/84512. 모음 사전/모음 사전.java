import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> list = new ArrayList<>();

    private char[] entry = {'A', 'E', 'I', 'O', 'U'};

    public int solution(String word) {
        dfs("", 0);

        return list.indexOf(word);
    }

    private void dfs(String str, int len) {
        if (len > 5) {
            return;
        }
        list.add(str);
        for (char target : entry) {
            dfs(str + target, len + 1);
        }
    }
}