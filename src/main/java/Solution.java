import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (String op : operations) {
            if (op.startsWith("I")) {
                String[] split = op.split(" ");
                minHeap.offer(Integer.parseInt(split[1]));
                maxHeap.offer(Integer.parseInt(split[1]));
            } else if (op.startsWith("D")) {
                String[] split = op.split(" ");
                if (split[1].startsWith("-")) {
                    maxHeap.remove(minHeap.poll());
                } else {
                    minHeap.remove(maxHeap.poll());
                }
            }
        }
        if (minHeap.isEmpty() || maxHeap.isEmpty()) return new int[]{0, 0};
        return new int[]{maxHeap.poll(), minHeap.poll()};
    }
}