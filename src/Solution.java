import java.util.LinkedList;
import java.util.Queue;

class Job {
    int id, priority;

    public Job(int id, int priority) {
        this.id = id;
        this.priority = priority;
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Job> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new Job(i, priorities[i]));
        }

        while (!queue.isEmpty()) {
            Job p = queue.poll();
            for (Job job : queue) {
                if (p.priority < job.priority) {
                    queue.offer(p);
                    p = null;
                    break;
                }
            }
            if (p != null) {
                answer++;
                if (p.id == location) return answer;
            }
        }
        return -1;
    }
}