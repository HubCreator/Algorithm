import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pqueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int work : works) pqueue.offer(work);

        for (int i = 0; i < n; i++)
            pqueue.offer(pqueue.poll() - 1);

        for (Integer x : pqueue) {
            if (x < 0) return 0;
            answer += Math.pow(x, 2);
        }
        return answer;
    }
}