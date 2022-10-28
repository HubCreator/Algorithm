import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> wishList = new HashMap<>();
        Map<String, Integer> win = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wishList.put(want[i], number[i]);
        }

        // 초기 윈도우 설정
        for (int i = 0; i < 9; i++) {
            win.put(discount[i], win.getOrDefault(discount[i], 0) + 1);
        }

        // 슬라이딩 윈도우
        int lt = 0;
        for (int rt = 9; rt < discount.length; rt++, lt++) {
            win.put(discount[rt], win.getOrDefault(discount[rt], 0) + 1);
            if (wishList.equals(win)) answer++;
            win.put(discount[lt], win.get(discount[lt]) - 1);
            if (win.get(discount[lt]) == 0) {
                win.remove(discount[lt]);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        String[] arr = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
        System.out.println(T.solution(new String[]{"banana", "apple", "rice", "pork", "pot"}, new int[]{3,2,2,2,1}, arr));
    }
}