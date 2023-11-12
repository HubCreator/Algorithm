import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        for (int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        List<Integer> values = map.values()
                .stream()
                .sorted((a, b) -> b - a)
                .collect(Collectors.toList());

        for (Integer value : values) {
            answer += 1;
            k -= value;
            if (k <= 0) {
                break;
            }
        }
        return answer;
    }
}
