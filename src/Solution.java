import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 1, curIdx = 1;
        Queue<Integer> bridge = new LinkedList<>();
        bridge.offer(truck_weights[0]);

        int sum;
        do {
            if (bridge.size() >= bridge_length) bridge.poll();

            sum = 0;
            for (Integer x : bridge) sum += x;
            if (curIdx < truck_weights.length && sum + truck_weights[curIdx] <= weight) {
                bridge.offer(truck_weights[curIdx++]);
            } else {
                bridge.offer(0);
            }
            answer++;
            sum = 0;
            for (Integer x : bridge) sum += x;
        } while (sum != 0);

        return answer;
    }
}