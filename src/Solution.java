import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, List<String>> map = new HashMap<>();
        for (String[] clothe : clothes) {
            if (map.get(clothe[1]) == null) map.put(clothe[1], new ArrayList<>());
            map.get(clothe[1]).add(clothe[0]);
        }
        for (Map.Entry<String, List<String>> e : map.entrySet()) {
            answer *= (e.getValue().size() + 1); // 각 옷을 입는 경우의 수와 모든 옷을 입지 않는 경우의 수
        }
        return answer - 1; // 옷을 적어도 하나 입고 있어야 하기 때문에, 모두 입고 있지 않는 경우의 수를 하나 빼줌
    }
}