import java.util.List;
import java.util.ArrayList;

class Stage implements Comparable<Stage> {
    int id;
    double fault;

    public Stage(int id, float fault) {
        this.id = id;
        this.fault = fault;
    }

    @Override
    public int compareTo(Stage o) {
        if (o.fault == this.fault) return this.id - o.id;
        else {
            if (o.fault - this.fault > 0) return 1;
            else if (o.fault - this.fault < 0) return -1;
            else return 0;
        }
    }
}

class Solution {
    public int[] solution(int N, int[] stages) {
        List<Stage> answer = new ArrayList<>();
        int curStage, unclear;

        for (int i = 1; i <= N; i++) {
            curStage = unclear = 0;
            for (int x : stages) {
                if (x >= i) curStage++;
                if (x == i) unclear++;
            }
            boolean b = curStage == 0 ? answer.add(new Stage(i, 0)) :
                    answer.add(new Stage(i, (float) unclear / curStage));

        }

        return answer.stream().sorted().mapToInt(m -> m.id).toArray();
    }
}