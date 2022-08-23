import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[] solution(int n, int[] arr) {
        List<Integer> answer = new ArrayList<>();
        for (int i : arr) answer.add(i);
        Collections.sort(answer, Collections.reverseOrder());

        for (int i : arr) System.out.print(answer.indexOf(i) + 1 + " ");

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int n = 5;
        int[] arr = {87, 92, 92, 100, 76};
        for (int x : T.solution(n, arr)) System.out.print(x + " ");
    }
}