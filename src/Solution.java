import java.util.*;

class Solution {

    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();
        for (int x : scoville) pQueue.add(x);

        while (pQueue.size() > 1 && pQueue.peek() < K) {
            pQueue.add(pQueue.poll() + pQueue.poll() * 2);
            answer++;
        }
        return !pQueue.isEmpty() && pQueue.peek() >= K ? answer : -1;
    }
}