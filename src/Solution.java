import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long sum1 = 0, sum2 = 0, cnt = 0;

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for (int x : queue1) {
            sum1 += x;
            q1.offer(x);
        }
        for (int x : queue2) {
            sum2 += x;
            q2.offer(x);
        }

        if (sum1 == sum2) return 0;
        while (sum1 != sum2 && cnt < queue1.length * 2.6) {
            Integer p;
            if (sum1 > sum2) {
                p = q1.poll();
                q2.offer(p);
                sum1 -= p;
                sum2 += p;
            } else {
                p = q2.poll();
                q1.offer(p);
                sum1 += p;
                sum2 -= p;
            }
            cnt++;
        }

        return cnt >= queue1.length * 2.6 ? -1 : (int) cnt;
    }
}