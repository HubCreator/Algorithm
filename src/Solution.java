import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Log {
    String status, userId;

    public Log(String status, String userId) {
        this.status = status;
        this.userId = userId;
    }
}

class Solution {
    List<Log> list;
    HashMap<String, String> map;
    private void writeLog(String r) {
        String[] split = r.split(" ");
        if(r.startsWith("Enter")) {
            list.add(new Log(split[0], split[1])); // status와 userId를 기록
            map.put(split[1], split[2]); // userId에 해당하는 userName을 저장
        } else if (r.startsWith("Change")) {
            map.put(split[1], split[2]); // userId에 해당하는 userName을 수정
        } else if (r.startsWith("Leave")) {
            list.add(new Log(split[0], split[1])); // status와 userId를 기록
        }
    }

    public String[] solution(String[] record) {
        ArrayList<String> answer = new ArrayList<>();
        list = new ArrayList<>();
        map = new HashMap<>();

        for (String r : record) writeLog(r);
        for (Log log : list) {
            StringBuilder sb = new StringBuilder();
            if (log.status.equals("Enter")) {
                sb.append(map.get(log.userId)).append("님이 들어왔습니다.");
            } else {
                sb.append(map.get(log.userId)).append("님이 나갔습니다.");
            }
            answer.add(sb.toString());
        }
        return answer.toArray(new String[0]);
    }
}