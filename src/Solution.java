import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pqueue = new PriorityQueue<>();
        for (int x : scoville) pqueue.offer(x);
        while (pqueue.size() >= 2 && pqueue.peek() < K) {
            pqueue.offer(pqueue.poll() + pqueue.poll() * 2);
            answer++;
        }
        return pqueue.peek() >= K ? answer : -1;
    }
}