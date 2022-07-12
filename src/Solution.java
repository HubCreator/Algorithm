import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

class Entry implements Comparable<Entry>{
    int key, cnt;

    public Entry(int key, int cnt) {
        this.key = key;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(Entry o) {
        return o.cnt - this.cnt;
    }
}
class Solution {
    public int[] solution(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<Entry> list = new ArrayList<>();
        s = s.replaceAll("[{|}]{1,}", "");
        String[] sub = s.split(",");
        for(int i = 0; i < sub.length; i++) {
            map.put(sub[i], map.getOrDefault(sub[i], 0) + 1);
        }
        for(Map.Entry<String, Integer> e : map.entrySet()) {
            list.add(new Entry(Integer.parseInt(e.getKey()), e.getValue()));
        }
        Collections.sort(list);

        return list.stream().map(m -> m.key).mapToInt(i -> i.intValue()).toArray();
    }
}