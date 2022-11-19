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
                sum -= bridge.poll();
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

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(2, 10, new int[]{7, 4, 5, 6}));
    }
}