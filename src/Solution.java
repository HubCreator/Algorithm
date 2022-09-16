import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        Deque<Integer> deque = new ArrayDeque<>();

        for (String operation : operations) {
            String[] s = operation.split(" ");
            int t = Integer.parseInt(s[1]);

            if (s[0].equals("I")) {
                if (deque.isEmpty()) {
                    deque.offerLast(t);
                } else {
                    if (t < deque.peekFirst()) deque.offerFirst(t);
                    if (t > deque.peekLast()) deque.offerLast(t);
                }
            } else if(s[0].equals("D")) {
                if (t < 0) deque.pollFirst();
                else deque.pollLast();
            }
        }
        return deque.isEmpty() ? new int[]{0, 0} : new int[]{deque.peekLast(), deque.peekFirst()};
    }
}