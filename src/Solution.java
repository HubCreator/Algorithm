import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();
        String[] entry = {"RT", "CF", "JM", "AN"};
        Map<Character, Integer> map = new HashMap<>();
        for (String s : entry) {
            map.put(s.charAt(0), 0);
            map.put(s.charAt(1), 0);
        }

        for (int i = 0; i < choices.length; i++) {
            int point = switch (choices[i]) {
                case 1, 7 -> 3;
                case 2, 6 -> 2;
                case 3, 5 -> 1;
                default -> 0;
            };
            Integer res = choices[i] < 4 ? map.put(survey[i].charAt(0), map.get(survey[i].charAt(0)) + point)
                    : map.put(survey[i].charAt(1), map.get(survey[i].charAt(1)) + point);
        }

        for (String s : entry) {
            if (map.get(s.charAt(0)) >= map.get(s.charAt(1))) answer.append(s.charAt(0));
            else answer.append(s.charAt(1));
        }

        return answer.toString();
    }
}