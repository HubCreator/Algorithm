import java.util.*;

class Solution {
    Set<Integer> answer = new HashSet<>();

    private void getSequenceSum(int[] elements, int i) {
        List<Integer> list = new ArrayList<>();
        for (int j = 0; j < elements.length * 2; j++) {
            list.add(elements[j % elements.length]);
        }
        // 초기 윈도우값 설정
        int win = 0, idx = 0;
        for (int j = 0; j < i; j++) {
            win += list.get(j);
        }
        for (int j = i; j < list.size(); j++) {
            win += list.get(j);
            answer.add(win);
            win -= list.get(idx++);
        }
    }

    public int solution(int[] elements) {
        for (int i = 0; i < elements.length; i++) {
            getSequenceSum(elements, i);
        }
        return answer.size();
    }
}