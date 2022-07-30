import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public int solution(int[] people, int limit) {
        List<Integer> list = new ArrayList<>();
        for (int p : people) list.add(p);
        list.sort(Collections.reverseOrder());

        int answer = 0;
        while (!list.isEmpty()) {
            Integer last = list.get(list.size() - 1);
            if (last * 2 > limit) return answer + list.size();

            Integer t = list.remove(0);
            if (list.isEmpty()) return answer + 1;

            if (t + last <= limit) list.remove(last);
            answer++;
        }
        return answer;
    }
}