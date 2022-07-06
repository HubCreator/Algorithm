import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    int[] prize = {6, 6, 5, 4, 3, 2, 1};

    public int[] solution(int[] lottos, int[] win_nums) {
        List<Integer> winNums = new ArrayList<>();
        for (int x : win_nums) winNums.add(x);
        int matchCnt = 0, zCnt = 0;
        for (int lotto : lottos) {
            if (winNums.contains(lotto)) matchCnt++;
            if (lotto == 0) zCnt++;
        }
//        System.out.println(matchCnt + " / " + zCnt);
        int min = matchCnt;
        int max = matchCnt + zCnt;

        return new int[]{prize[max], prize[min]};
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int[] a = {0, 0, 0, 0, 0, 0};
        int[] b = {38, 19, 20, 40, 15, 25};
        for (int x : T.solution(a, b)) System.out.print(x + " ");
    }
}