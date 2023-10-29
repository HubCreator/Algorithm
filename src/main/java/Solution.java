import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        long sum = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int work : works) {
            maxHeap.offer(work);
            sum += work;
        }
        if (sum < n) {
            return 0;
        }
        for (int i = 0; i < n; i++) {
            maxHeap.offer(maxHeap.poll() - 1);
        }
        for (Integer integer : maxHeap) {
            answer += Math.pow(integer, 2);
        }
        return answer;
    }
}
