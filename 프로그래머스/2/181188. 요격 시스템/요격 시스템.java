import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 1;
        Arrays.sort(targets, (a, b) -> a[0] - b[0]);
        
        int[] prev = targets[0];
        for (int i = 1; i < targets.length; i++) {
            int s = targets[i][0];
            int e = targets[i][1];
            
            if (prev[0] <= s && s < prev[1]) {
                prev[0] = Math.max(prev[0], s);
                prev[1] = Math.min(prev[1], e);
            } else {
                prev = targets[i];
                answer++;
            }
        }
        
        return answer;
    }
}