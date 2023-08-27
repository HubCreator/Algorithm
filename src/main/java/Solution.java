import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        Queue<Integer> minHeap = new PriorityQueue<>();
        for (int s : scoville) {
            minHeap.offer(s);
        }
        while (minHeap.size() >= 2 && minHeap.peek() < K) {
            Integer poll1 = minHeap.poll();
            Integer poll2 = minHeap.poll();
            minHeap.offer(poll1 + (poll2 * 2));
            answer += 1;
        }
        if (!minHeap.isEmpty() && minHeap.poll() < K) {
            return -1;
        }
        return answer;
    }
}
