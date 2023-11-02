import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
         for (int i = 0; i < sequence.length; i++) {
            if (sequence[i] == k) {
                return new int[]{i, i};
            }
        }
        List<int[]> result = new ArrayList<>();
        
        int lt = 0, rt = 0, sum = 0;
        for (rt = 0; rt < sequence.length; rt++) {
            sum += sequence[rt];
            if (sum == k) {
                result.add(new int[]{lt, rt});
                continue;
            } 
            while (sum > k) {
                sum -= sequence[lt++];
            }
            if (sum == k) {
                result.add(new int[]{lt, rt});
            } 
        }
        Collections.sort(result, (a, b) -> {
            int aLen = a[1] - a[0] + 1;
            int bLen = b[1] - b[0] + 1;
            if (aLen == bLen) {
                return Integer.compare(a[0], b[0]);
            }
            if (aLen < bLen) {
                return -1;
            }
            return 1;
        });
        return result.get(0);
    }
}