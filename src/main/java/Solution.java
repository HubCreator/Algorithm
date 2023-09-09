import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Deque<String> deque = new ArrayDeque<>();
        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toLowerCase();
            if (deque.isEmpty() || !deque.contains(city)) {
                answer += 5;
                deque.offerFirst(city);
                if (deque.size() > cacheSize) {
                    deque.pollLast();
                }
                continue;
            }
            if (deque.contains(city)) {
                deque.remove(city);
                deque.offerFirst(city);
                answer += 1;
            }
        }
        return answer;
    }
}
