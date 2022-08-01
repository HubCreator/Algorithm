import java.util.*;

class Job implements Comparable<Job> {
    int startAt, duration;

    public Job(int a, int b) {
        this.startAt = a;
        this.duration = b;
    }

    @Override
    public int compareTo(Job o) {
        if (this.startAt == o.startAt) return this.duration - o.duration;
        else return this.startAt - o.startAt;
    }
}

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0, cur = 0;
        List<Job> list = new ArrayList<>();
        for (int[] e : jobs) list.add(new Job(e[0], e[1]));
        Collections.sort(list);
        Deque<Job> dq = new LinkedList<>(list);
        while (!dq.isEmpty()) {
            Job p = dq.peekFirst();
            if (cur <= p.startAt) {
                dq.pollFirst();
                cur = p.startAt + p.duration;
            } else {
                List<Job> tmp = new ArrayList<>();
                while (!dq.isEmpty() && dq.peekFirst().startAt < cur) {
                    tmp.add(dq.pollFirst());
                }
                Collections.sort(tmp, (a, b) -> b.duration - a.duration);
                for (Job j : tmp) dq.offerFirst(j);
                p = dq.pollFirst();
                cur += p.duration;
            }
            answer += cur - p.startAt;
        }
        return answer / jobs.length;
    }
}