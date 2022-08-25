import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Job {
    int progress, speed;

    public Job(int progress, int speed) {
        this.progress = progress;
        this.speed = speed;
    }
}

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Job> queue = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();
        int cnt;
        for (int i = 0; i < progresses.length; i++) {
            queue.offer(new Job(progresses[i], speeds[i]));
        }
        while (!queue.isEmpty()) {
            cnt = 0;
            for (Job job : queue) job.progress += job.speed;
            while (!queue.isEmpty() && queue.peek().progress >= 100) {
                queue.poll();
                cnt++;
            }
            if (cnt > 0) answer.add(cnt);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int[] arr1 = {95, 90, 99, 99, 80, 99};
        int[] arr2 = {1, 1, 1, 1, 1, 1};
        for (int x : T.solution(arr1, arr2)) System.out.print(x + " ");
    }
}