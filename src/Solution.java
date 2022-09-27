import java.time.Duration;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, LocalTime> info = new HashMap<>(); // <차량 번호, 입차 시간>
        Map<String, Integer> result = new HashMap<>(); // <차량 번호, 누적 시간(분)>
        Map<String, Integer> answer = new LinkedHashMap<>(); // <차량 번호, 가격>
        for (String record : records) {
            String[] s = record.split(" ");
            String[] time = s[0].split(":");
            int hour = Integer.parseInt(time[0]), min = Integer.parseInt(time[1]);
            LocalTime localTime = LocalTime.of(hour, min);
            if (s[2].equals("IN")) {
                info.put(s[1], localTime);
                answer.put(s[1], 0);
            } else {
                LocalTime timeOUT = info.get(s[1]);
                Duration duration = Duration.between(timeOUT, localTime);
                result.put(s[1], result.getOrDefault(s[1], 0) + (int) (duration.getSeconds() / 60));
                info.remove(s[1]);
            }
        }
        // TODO : 24시를 체크하기 위해 남아있는 info들을 돌면서 추가 작업을 해주어야 함
        for (Map.Entry<String, LocalTime> e : info.entrySet()) {
            Duration duration = Duration.between(LocalTime.of(23, 59), e.getValue());
            result.put(e.getKey(), result.getOrDefault(e.getKey(), 0) + (int) (-duration.getSeconds() / 60));
        }
        for (Map.Entry<String, Integer> e : result.entrySet()) {
            if (e.getValue() < fees[0])
                answer.put(e.getKey(), answer.getOrDefault(e.getKey(), 0) + fees[1]);
            else{
                int feeResult = fees[1] + (int) Math.ceil((double) (e.getValue() - fees[0]) / fees[2]) * fees[3];
                answer.put(e.getKey(), answer.getOrDefault(e.getKey(), 0) + feeResult);
            }
        }

        return answer.keySet().stream().sorted().mapToInt(m -> answer.get(m).intValue()).toArray();
    }

}