import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer> stack = new ArrayList<>();
        
        for (int i = 1; i <= order.length; i++) {
            queue.offer(i);
        }
        
        for (int i = 0; i < order.length; i++) {
            int target = order[i];
            if (!stack.contains(target)) {
                while (queue.peek() != target) {
                    stack.add(queue.poll());
                }
                queue.poll();
                answer++;
                continue;
            }
            if (stack.get(stack.size() - 1) == target) {
                stack.remove(stack.size() - 1);
                answer++;
            } else {
                break;
            }
        }
        
        return answer;
    }
}