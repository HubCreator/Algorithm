import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(String msg) {
        List<Integer> result = new ArrayList<>();
        List<String> dict = new ArrayList<>();
        int cnt, idx;
        msg += "!";

        for (int i = 'A'; i <= 'Z'; i++) dict.add(String.valueOf((char) i));

        for (int i = 0; i < msg.length() - 1; ) {
            cnt = 0;
            idx = i;

            StringBuilder sb = new StringBuilder();
            sb.append(msg.charAt(i));

            do {
                cnt++;
                sb.append(msg.charAt(++idx));
            } while (dict.contains(sb.toString()));

            dict.add(sb.toString());
            result.add(dict.indexOf(sb.substring(0, sb.length() - 1)));

            if (cnt > 1) i += cnt;
            else i++;
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < answer.length; i++) answer[i] = result.get(i) + 1;

        return answer;
    }
}