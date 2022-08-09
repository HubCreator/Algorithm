import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

class Solution {
    private final static int CACHE_HIT = 1;
    private final static int CACHE_MISS = 5;

    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) return cities.length * CACHE_MISS;
        int answer = 0;
        Deque<String> deque = new LinkedList<>();
        for (String tmp : cities) {
            String city = tmp.toLowerCase();
            if (deque.contains(city)) {
                deque.remove(city);
                deque.offerFirst(city);
                answer += CACHE_HIT;
            } else {
                if (deque.size() == cacheSize) deque.pollLast();
                deque.offerFirst(city);
                answer += CACHE_MISS;
            }
        }

        return answer;
    }
}