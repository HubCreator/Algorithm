import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    Deque<Integer> deque = new ArrayDeque<>();

    public int[] solution(String[] operations) {
        for (String operation : operations) {
            addToDeque(operation);
        }
        if (!deque.isEmpty()) {
            return new int[]{deque.peekLast(), deque.peekFirst()};
        }
        return new int[]{0, 0};
    }

    private void addToDeque(String operation) {
        String[] split = operation.split(" ");

        if (split[0].equals("I")) {
            int t = Integer.parseInt(split[1]);
            if (deque.isEmpty() || deque.peekLast() <= t) {
                deque.offerLast(t);
            } else if (deque.peekFirst() >= t) {
                deque.offerFirst(t);
            }
        } else if (split[0].equals("D") && !deque.isEmpty()) {
            if (split[1].equals("-1")) {
                deque.pollFirst();
            } else {
                deque.pollLast();
            }
        }
    }
}
