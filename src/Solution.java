import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        List<int[]> entry = new ArrayList<>();
        int area = brown + yellow;
        for (int i = area - 1; i >= 0; i--) {
            if (area % i == 0) {
                int divided = area / i;
                if (i < divided) break;
                if (divided >= 3)
                    entry.add(new int[]{i, divided});
            }
        }
        if (entry.size() == 1) return entry.get(0);
        else {
            for (int[] arr : entry) {
                if (area - arr[0] * 2 - arr[1] * 2 + 4 == yellow)
                    return arr;
            }
        }
        return answer;
    }
}