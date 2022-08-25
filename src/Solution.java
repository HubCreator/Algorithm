import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int solution(int[] times, long k) {
        int cur = -1;
        double size = times.length;
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            map.put(i, times[i - 1]);
            list.add(i);
        }

        while (k >= 0) {
            cur++;
            if (cur == size + 1) cur = 1;
            if (!list.contains(cur)) {
                double lt = 0;
                double rt = list.size() - 1;
                while (lt <= rt) {
                    int mid = (int) ((lt + rt) / 2);
                    if (list.get(mid) < cur) lt = mid + 1;
                    else rt = mid - 1;
                }
                cur = list.get((int) lt);
            }
            if (map.get(cur) == 1) {
                map.remove(cur);
                list.remove((Integer) cur);
            } else map.put(cur, map.get(cur) - 1);
            k--;
        }
        return cur;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int[] arr = {4, 2, 3, 6, 7, 1, 5, 8};
        int k = 27;
        System.out.println(T.solution(arr, k));
    }
}