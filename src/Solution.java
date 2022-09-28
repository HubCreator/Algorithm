import java.util.LinkedHashMap;
import java.util.Map;

class Solution {

    public int timeToInt(String time) {
        String tmp[] = time.split(":");
        return Integer.parseInt(tmp[0]) * 60 + Integer.parseInt(tmp[1]);
    }

    public int[] solution(int[] fees, String[] records) {

        Map<String, Integer> map = new LinkedHashMap<>(); // <차량 번호, 가격>

        for (String record : records) {
            String[] split = record.split(" ");
            int time = timeToInt(split[0]);
            time *= split[2].equals("IN") ? -1 : 1;
            map.put(split[1], map.getOrDefault(split[1], 0) + time);
        }

        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if (e.getValue() < 1)
                map.put(e.getKey(), e.getValue() + timeToInt("23:59"));
            if (e.getValue() <= fees[0])
                map.put(e.getKey(), fees[1]);
            else
                map.put(e.getKey(), fees[1] + (int) Math.ceil((double) (e.getValue() - fees[0]) / fees[2]) * fees[3]);
        }

        return map.keySet().stream().sorted().mapToInt(m -> map.get(m).intValue()).toArray();
    }
}