import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public Set<Integer> answer = new HashSet<>();
    public List<Integer> list;

    public int solution(int[] elements) {
        list = getList(elements);
        for (int len = 1; len <= elements.length; len++) {
            boolean[] check = new boolean[list.size()];
            int[] pm = new int[len];
            dfs(check, pm, len, 0);
        }
        return answer.size();
    }

    public void dfs(boolean[] check, int[] pm, int len, int level) {
        if (len == level) {
            int sum = 0;
            for (int t : pm) {
                sum += list.get(t);
            }
            System.out.println(level + " " + sum);
            answer.add(sum);
        } else {
            for (int i = 0; i < list.size(); i++) {
                if (!check[i]) {
                    check[i] = true;
                    pm[level] = i;
                    dfs(check, pm, len, level + 1);
                    check[i] = false;
                }
            }
        }
    }

    public List<Integer> getList(int[] elements) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < elements.length; i++) {
            result.add(elements[i]);
        }
        for (int i = 0; i < elements.length; i++) {
            result.add(elements[i]);
        }
        return result;
    }
}
