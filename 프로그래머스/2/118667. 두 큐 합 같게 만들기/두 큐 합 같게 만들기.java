import java.util.Queue;
import java.util.ArrayDeque;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long totalSum = 0, sum = 0;
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        for (int i = 0; i < queue1.length; i++) {
            totalSum += queue1[i];
            totalSum += queue2[i];
            sum += queue1[i];
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
        }
        
        long target = totalSum / 2;
        Integer poll = null;
        while (sum != target) {
            if (q1.isEmpty() || q2.isEmpty() || answer > 600_000) {
                return -1;
            }
            answer++;
            if (sum > target) {
                poll = q1.poll();
                q2.offer(poll);
                sum -= poll;
                continue;
            } 
            poll = q2.poll();
            q1.offer(poll);
            sum += poll;
        }
        
        return answer;
    }
}