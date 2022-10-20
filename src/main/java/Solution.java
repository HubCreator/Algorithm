import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        Deque<Integer> deque = new ArrayDeque<>();

        for (String op : operations) {
            String[] s = op.split(" ");
            int val = Integer.parseInt(s[1]);
            if (op.startsWith("I")) {
                if (deque.isEmpty()) deque.offer(val);
                else if (val <= deque.peekFirst()) deque.offerFirst(val);
                else if (val >= deque.peekLast()) deque.offerLast(val);
            } else if (op.startsWith("D")) {
                if (val < 0) deque.pollFirst();
                else if (val > 0) deque.pollLast();
            }
        }
        if (deque.isEmpty()) return new int[]{0, 0};
        return new int[]{deque.peekLast(), deque.peekFirst()};
    }
}