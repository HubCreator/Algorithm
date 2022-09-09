import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String str1, String str2) {
        int sum = 0;
        double common = 0;
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for (int i = 0; i < str1.length() - 1; i++) {
            String s = str1.substring(i, i + 2);
            if (s.matches("[a-zA-Z]{2}"))
                map1.put(s.toLowerCase(), map1.getOrDefault(s.toLowerCase(), 0) + 1);
        }
        for (int i = 0; i < str2.length() - 1; i++) {
            String s = str2.substring(i, i + 2);
            if (s.matches("[a-zA-Z]{2}"))
                map2.put(s.toLowerCase(), map2.getOrDefault(s.toLowerCase(), 0) + 1);
        }

        if (!map1.isEmpty()) {
            for (String s : map1.keySet()) {
                if(!map2.isEmpty() && map2.containsKey(s)) sum += Math.max(map1.get(s), map2.get(s));
                else sum += map1.get(s);
            }
            for (String s : map2.keySet()) {
                if(!map1.containsKey(s)) sum += map2.get(s);
            }
        }
        if (!map1.isEmpty()) {
            for (String s : map1.keySet()) {
                if (!map2.isEmpty() && map2.containsKey(s)) common += Math.min(map1.get(s), map2.get(s));
            }
        }
        return map1.isEmpty() && map2.isEmpty() ? 65536 : (int)(common / sum * 65536);
    }
}