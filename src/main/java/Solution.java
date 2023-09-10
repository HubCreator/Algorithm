import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> wishMap = new HashMap<>();
        Map<String, Integer> discountMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wishMap.put(want[i], number[i]);
        }
        for (int i = 0; i < 9; i++) {
            discountMap.put(discount[i], discountMap.getOrDefault(discount[i], 0) + 1);
        }
        int lt = 0;
        for (int i = 9; i < discount.length; i++, lt++) {
            discountMap.put(discount[i], discountMap.getOrDefault(discount[i], 0) + 1);
            if (wishMap.equals(discountMap)) {
                answer += 1;
            }
            discountMap.put(discount[lt], discountMap.get(discount[lt]) - 1);
            if (discountMap.get(discount[lt]) == 0) {
                discountMap.remove(discount[lt]);
            }
        }
        return answer;
    }
}
