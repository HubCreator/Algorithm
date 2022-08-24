import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int cnt = 0, blank = 0;
        int[] prize = {6, 6, 5, 4, 3, 2, 1};
        List<Integer> winNumsList = new ArrayList<>();
        for (int x : win_nums) winNumsList.add(x);
        for (int lotto : lottos) {
            if (winNumsList.contains(lotto)) cnt++;
            if (lotto == 0) blank++;
        }
        return new int[]{prize[cnt + blank], prize[cnt]};
    }
}