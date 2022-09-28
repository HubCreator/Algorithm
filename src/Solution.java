import java.util.Map;
import java.util.TreeMap;

class Solution {

    /**
     * 분 단위로 변환
     *
     * @param time
     * @return min
     */
    public int timeToInt(String time) {
        String temp[] = time.split(":");
        return Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
    }

    public int[] solution(int[] fees, String[] records) {

        Map<String, Integer> map = new TreeMap<>();

        for (String record : records) {
            String tmp[] = record.split(" ");
            int time = tmp[2].equals("IN") ? -1 : 1;
            time *= timeToInt(tmp[0]);
            map.put(tmp[1], map.getOrDefault(tmp[1], 0) + time);
        }

        int idx = 0;
        int[] answer = new int[map.size()];

        for (int time : map.values()) {
            if (time < 1) time += timeToInt("23:59");
            if (time <= fees[0])
                answer[idx++] = fees[1];
            else
                answer[idx++] = fees[1] + (int) Math.ceil((double) (time - fees[0]) / fees[2]) * fees[3];
        }
        return answer;
    }
}