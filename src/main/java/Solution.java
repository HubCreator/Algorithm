import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[] stones, int k) {
        PriorityQueue<Integer> entry = new PriorityQueue<>();

        // 초기 윈도우
        PriorityQueue<Integer> window = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < k - 1; i++) {
            window.offer(stones[i]);
        }
        int lt = 0;
        for (int rt = k - 1; rt < stones.length; rt++) {
            window.offer(stones[rt]);
            entry.offer(window.peek());
            window.remove(stones[lt++]);
        }
        return entry.peek();
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        System.out.println(T.solution(stones, 3));
    }
}