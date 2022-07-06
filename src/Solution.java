import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        List<String> list = Arrays.stream(report).distinct().collect(Collectors.toList()); // 중복된 report 제거
        Map<String, Integer> count = new HashMap<>(); // 누가 몇 번 신고당했는지
        for (String s : list) {
            String target = s.split(" ")[1];
            count.put(target, count.getOrDefault(target, 0) + 1);
        }

        return Arrays.stream(id_list).map(_user -> {
            final String user = _user;
            List<String> reportList = list.stream().filter(s -> s.startsWith(user + " ")).collect(Collectors.toList());
            return reportList.stream().filter(s -> count.getOrDefault(s.split(" ")[1], 0) >= k).count();
        }).mapToInt(Long::intValue).toArray();
    }
}