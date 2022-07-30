import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        List<Integer> list = new ArrayList<>();
        for (int p : people) list.add(p);
        list.sort(Collections.reverseOrder());

        ArrayDeque<Integer> deque = new ArrayDeque<>(50000);
        for (Integer x : list) deque.offer(x);

        int answer = 0;
        while (!deque.isEmpty()) {
            if (deque.getLast() * 2 > limit) return answer + deque.size();

            Integer p = deque.pollFirst();
            if(deque.isEmpty()) return answer + 1;

            else if (p + deque.getLast() <= limit) deque.pollLast();
            answer++;
        }
        return answer;
    }
}