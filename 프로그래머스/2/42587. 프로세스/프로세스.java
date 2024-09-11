import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Deque<Job> queue = new ArrayDeque<>();
        Queue<Integer> p = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new Job(priorities[i], i));
            p.offer(priorities[i]);
        }
        
        while (!p.isEmpty()) {
            int highest = p.poll();
            Job job = null;
            while (true) {
                job = queue.pollFirst();
                if (job.priority != highest) {
                    queue.offerLast(job);    
                } else {
                    break;
                }
            } 
            answer++;
                
            if (job.index == location) {
                return answer;
            }
        }
        return answer;
    }
}

class Job {
    public int priority;
    public int index;
    
    public Job(int priority, int index) {
        this.priority = priority;
        this.index = index;
    }
}