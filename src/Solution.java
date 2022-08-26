import java.util.ArrayList;
import java.util.List;

class Food {
    int id, time;

    public Food(int id, int time) {
        this.id = id;
        this.time = time;
    }

    public void reduceTime() {
        this.time--;
    }

    public boolean isOne() {
        return this.time == 1;
    }
}

class Solution {
    public int solution(int[] times, long k) {
        int idx = 0;
        List<Food> list = new ArrayList<>();
        for (int i = 0; i < times.length; i++) {
            list.add(new Food(i + 1, times[i]));
        }
        while (k > 0L) {
            if (list.get(idx).isOne())
                list.remove(idx--);
            else
                list.get(idx).reduceTime();
            idx++;
            if (idx == list.size()) idx = 0;
            k -= 1L;
        }

        return list.isEmpty() ? -1 : list.get(idx).id;
    }
}