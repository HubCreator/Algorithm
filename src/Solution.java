import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Player implements Comparable<Player> {
    int w, h;

    public Player(int h, int w) {
        this.h = h;
        this.w = w;
    }

    @Override
    public int compareTo(Player o) {
        return o.h - this.h;
    }
}

public class Solution {
    public int solution(int[][] arr) {
        int answer = arr.length;
        List<Player> list = new ArrayList<>();
        for (int[] p : arr) {
            list.add(new Player(p[0], p[1]));
        }
        Collections.sort(list);
        for (int i = 1; i < list.size(); i++) {
            Player t = list.get(i);
            for (int j = i - 1; j >= 0; j--) {
                if (t.w < list.get(j).w) {
                    answer--;
                    break;
                }
            }

        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int[][] arr = {
                {172, 67},
                {183, 65},
                {180, 70},
                {170, 72},
                {181, 60}
        };
        System.out.println(T.solution(arr));
    }
}