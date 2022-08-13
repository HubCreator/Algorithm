import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[] times, long k) {
        Long cur = -1L;
        Map<Long, Integer> map = new HashMap<>();
        for (long i = 0; i < times.length; i++) map.put(i, times[(int)i]);

        while (k >= 0 && !map.isEmpty()) {
            cur = (cur + 1) % times.length;
            if (map.containsKey(cur)) {
                map.put(cur, map.get(cur) - 1);
                if (map.get(cur) == 0) map.remove(cur);
            } else {
                while (!map.containsKey(cur)) cur = (cur + 1) % times.length;
                map.put(cur, map.get(cur) - 1);
                if (map.get(cur) == 0) map.remove(cur);
            }
            k--;
        }

        return k >= 0 ? -1 : (int)(cur + 1);
    }
}