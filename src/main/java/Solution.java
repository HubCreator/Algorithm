import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Work> works = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();

        for (int i = progresses.length - 1; i >= 0; i--) {
            works.add(new Work(progresses[i], speeds[i]));
        }
        while (!works.isEmpty()) {
            for (Work work : works) {
                work.update();
            }
            int tmp = 0;
            while (!works.isEmpty() && works.get(works.size() - 1).progress >= 100) {
                works.remove(works.size() - 1);
                tmp++;
            }
            if (tmp > 0) {
                answer.add(tmp);
            }
        }

        return answer.stream().mapToInt(m -> m).toArray();
    }

    private static class Work {
        public int progress;
        public int speed;

        public Work(int progress, int speed) {
            this.progress = progress;
            this.speed = speed;
        }

        public int update() {
            return progress += speed;
        }
    }
}
