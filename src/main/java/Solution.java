import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public int solution(int[] cards) {
        int curBox = 0, curIdx, sum = Arrays.stream(cards).sum();

        List<List<Integer>> list = new ArrayList<>();

        while (sum != 0) {
            curIdx = 0;
            while (cards[curIdx] == 0) curIdx++;
            list.add(new ArrayList<>());

            while (cards[curIdx] != 0) {
                list.get(curBox).add(cards[curIdx]);
                int tmp = curIdx;
                sum -= cards[curIdx];
                curIdx = cards[curIdx] - 1;
                cards[tmp] = 0;
            }
            curBox++;
        }

        Collections.sort(list, (a, b) -> b.size() - a.size());
        if (list.size() == 1) return 0;
        return list.get(0).size() * list.get(1).size();
    }
}