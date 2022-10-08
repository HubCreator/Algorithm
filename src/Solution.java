import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        List<String> dict = new ArrayList<>();
        int idx;
        msg += "!";

        for (int i = 'A'; i <= 'Z'; i++) dict.add(String.valueOf((char) i));

        for (int i = 0; i < msg.length() - 1; ) {
            int cnt = 0;
            idx = i;
            StringBuilder sb = new StringBuilder();
            sb.append(msg.charAt(i));

            do {
                cnt++;
                sb.append(msg.charAt(++idx));
            } while (dict.contains(sb.toString()) && idx < msg.length() - 1);

            dict.add(sb.toString());
            answer.add(dict.indexOf(sb.substring(0, sb.length() - 1)));

            if (cnt > 1) i += cnt;
            else i++;
        }
        return answer.stream().mapToInt(i -> i + 1).toArray();
    }
}