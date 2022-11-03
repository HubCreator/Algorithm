import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        Set<String> entry = new HashSet<>(Arrays.asList(gems));
        Map<String, Integer> map = new HashMap<>();

        int lt = 0, length = Integer.MAX_VALUE;
        for (int rt = 0; rt < gems.length; rt++) {
            map.put(gems[rt], map.getOrDefault(gems[rt], 0) + 1);

            while (map.get(gems[lt]) >= 2) {
                map.put(gems[lt], map.get(gems[lt]) - 1);
                lt++;
            }

            if (map.size() == entry.size() && length > (rt - lt)) {
                length = rt - lt;
                answer[0] = lt + 1;
                answer[1] = rt + 1;
            }
        }
        return answer;
    }
}