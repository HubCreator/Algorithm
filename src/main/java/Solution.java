import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();

        int count;
        Queue<Job> jobs = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            jobs.offer(new Job(progresses[i], speeds[i]));
        }

        while (!jobs.isEmpty()) {
            for (Job job : jobs) {
                job.process();
            }
            count = 0;
            while (!jobs.isEmpty() && jobs.peek().progress >= 100) {
                count += 1;
                jobs.poll();
            }
            if (count > 0) {
                result.add(count);
            }
        }
        int[] answer = new int[result.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }

    private static class Job {
        public int progress;
        public int speed;

        public Job(int progress, int speed) {
            this.progress = progress;
            this.speed = speed;
        }

        public void process() {
            progress += speed;
        }
    }
}
