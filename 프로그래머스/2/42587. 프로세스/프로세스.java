import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Deque<Job> deque = new ArrayDeque<>();
        for (int i = 0; i < priorities.length; i++) {
            deque.offer(new Job(i, priorities[i]));
        }
        
        while (!deque.isEmpty()) {
            Job poll = deque.pollFirst();
            boolean flag = false;
            for (Job job : deque) {
                if (poll.priority < job.priority) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                deque.offerLast(poll);
            } else {
                answer += 1;
                if (poll.index == location) {
                    return answer;
                }    
            }
            
        }
        return answer;
    }
    
    private static class Job {
        private int index;
        private int priority;
        
        public Job(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }
}