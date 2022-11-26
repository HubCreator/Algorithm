import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        int tmp = 0, answer = 0;
        for (int x : tangerine) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        Collection<Integer> entry = map.values();
        List<Integer> result = entry.stream().sorted((a, b) -> b - a).collect(Collectors.toList());
        for (Integer x : result) {
            tmp += x;
            answer++;
            if (tmp >= k) break;
        }
        return answer;
    }
}