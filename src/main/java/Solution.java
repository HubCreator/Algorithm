import java.util.*;

class Solution {
    public String solution(String input_string) {
        Map<Character, Integer> map = new HashMap<>();
        List<Character> stack = new ArrayList<>();
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < input_string.length(); i++) {
            char target = input_string.charAt(i);
            map.put(target, map.getOrDefault(target, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Character key = entry.getKey();
            int start = input_string.indexOf(key);
            String subString = input_string.substring(start, start + entry.getValue());
            for (int j = 0; j < subString.length(); j++) {
                if (subString.charAt(j) != entry.getKey()) {
                    stack.add(entry.getKey());
                    break;
                }
            }
        }
        if (stack.isEmpty()) {
            return "N";
        }
        Collections.sort(stack);
        for (Character character : stack) {
            answer.append(character);
        }
        return answer.toString();
    }
}
