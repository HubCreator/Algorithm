import java.util.*;

class Stage implements Comparable<Stage> {
    int stageNum;
    double faultRate;


    public Stage(int stageNum) {
        this.stageNum = stageNum;
    }

    public void setFaultRate(int[] stages) {
        int i, cnt = 0;
        for (i = 0; i < stages.length; i++) {
            if (stages[i] > stageNum) break;
            if (stages[i] == stageNum) cnt++;
        }
        if (cnt > 0) faultRate = (double) cnt / (cnt + (stages.length - i));
        else faultRate = 0d;
    }

    @Override
    public int compareTo(Stage o) {
        if (o.faultRate == this.faultRate) return this.stageNum - o.stageNum;
        else {
            if (this.faultRate > o.faultRate) return -1;
            else return 1;
        }
    }
}

class Solution {
    static int[] _stages;

    public int[] solution(int N, int[] stages) {
        int[] _stages = stages.clone();
        Arrays.sort(_stages);
        ArrayList<Stage> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) list.add(new Stage(i)); // 1 ~ N까지의 stage 생성

        for (Stage el : list) el.setFaultRate(_stages);
        Collections.sort(list);
        return list.stream().map(m -> m.stageNum).mapToInt(Integer::intValue).toArray();
    }
}