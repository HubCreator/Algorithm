import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[]{0, 1};
        boolean flag = false;
        Set<String> set = new HashSet<>();
        set.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            answer[0] = i % n + 1;
            if (i % n == 0) {
                answer[1] += 1;
            }
            String target = words[i];
            if (!set.add(target)) {
                flag = true;
                break;
            }
            String[] split = target.split("");
            if (!words[i - 1].endsWith(split[0])) {
                return answer;
            }
        }
        if (!flag && answer[0] == n && answer[1] == words.length / n) {
            return new int[]{0, 0};
        }
        return answer;
    }
}
