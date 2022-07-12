import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 1, curIdx = 1;
        Queue<Integer> bridge = new LinkedList<>();
        bridge.offer(truck_weights[0]);

        int sum = truck_weights[0];
        do {
            if (bridge.size() >= bridge_length) {
                Integer p = bridge.poll();
                sum -= p;
            }

            if (curIdx < truck_weights.length && sum + truck_weights[curIdx] <= weight) {
                sum += truck_weights[curIdx];
                bridge.offer(truck_weights[curIdx++]);
            } else {
                bridge.offer(0);
            }
            answer++;
        } while (sum != 0);

        return answer;
    }
}