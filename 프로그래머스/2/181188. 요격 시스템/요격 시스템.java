import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 1;
        Arrays.sort(targets, (a, b) -> a[1] - b[1]);
        
        int preS = targets[0][0];
        int preE = targets[0][1];
        
        for (int i = 1; i < targets.length; i++) {
            int curS = targets[i][0];
            int curE = targets[i][1];
            
            if (preE > curS) {
                continue;
            }
            answer++;
            preS = curS;
            preE = curE;
        }
        
        return answer;
    }
}