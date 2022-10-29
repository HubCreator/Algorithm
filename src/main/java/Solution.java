import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int len = 2 * w + 1;
        List<Integer> list = new ArrayList<>();

        int point = 1;
        for (int station : stations) {
            list.add((station - w) - point);
            point = station + w + 1;
        }
        if (stations[stations.length - 1] + w < n) {
            list.add(n - point + 1);
        }

        for (Integer x : list) {
            answer += (int) Math.ceil((double) x / len);
        }
        return answer;
    }
}