import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<Integer, List<Character>> index = Map.of(
                0, List.of('R', 'T'),
                1, List.of('C', 'F'),
                2, List.of('J', 'M'),
                3, List.of('A', 'N')
        );

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < survey.length; i++) {
            int choice = choices[i];
            String s = survey[i];
            if (choice == 4) {
                continue;
            }
            if (choice > 4) {
                map.put(s.charAt(1), map.getOrDefault(s.charAt(1), 0) + (choice - 4));
            }
            if (choice < 4) {
                map.put(s.charAt(0), map.getOrDefault(s.charAt(0), 0) + (4 - choice));
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            List<Character> chars = index.get(i);
            Integer a = map.getOrDefault(chars.get(0), 0);
            Integer b = map.getOrDefault(chars.get(1), 0);
            if (a < b) {
                answer.append(chars.get(1));
                continue;
            }
            answer.append(chars.get(0));
        }

        return answer.toString();
    }
}