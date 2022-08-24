import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(String s) {
        int answer = s.length();
        Queue<String> queue = new LinkedList<>();

        for (int i = 1; i <= s.length() / 2; i++) {
            int idx = 0, j = 0;
            StringBuilder str = new StringBuilder();
            queue.clear();
            while (idx < s.length()) {
                StringBuilder sb = new StringBuilder();
                int len = j + i;
                for (; j < len && idx < s.length(); j++) {
                    sb.append(s.charAt(idx++));
                }
                queue.offer(sb.toString());
            }

            String pop1 = queue.poll();
            int cnt = 1;
            while (!queue.isEmpty()) {
                String pop2 = queue.poll();
                if (pop1.equals(pop2)) cnt++;
                else {
                    if (cnt > 1) str.append(cnt).append(pop1);
                    else str.append(pop1);
                    cnt = 1;
                }
                pop1 = pop2;
            }
            if (cnt > 1) str.append(cnt).append(pop1);
            else str.append(pop1);
            answer = Math.min(answer, str.toString().length());
        }
        return answer;
    }
}