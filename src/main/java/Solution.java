import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 1};
        Set<String> set = new HashSet<>();
        set.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            answer[0] = i % n + 1;
            if (i % n == 0) {
                answer[1] += 1;
            }
            String curr = words[i];
            String prev = words[i - 1];
            if (set.add(curr) && prev.charAt(prev.length() - 1) == curr.charAt(0)) {
                continue;
            } else {
                return answer;
            }
        }

        return new int[]{0, 0};
    }
}
