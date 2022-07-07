import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx = 0;
        List<Integer> list = new ArrayList<>();

        for (int[] command : commands) {
            int from = command[0] - 1;
            int to = command[1] - 1;
            int at = command[2] - 1;

            for (int i = from; i <= to; i++) list.add(array[i]);
            Collections.sort(list);

            answer[idx] = list.get(at);

            list.clear();
            idx++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int[] arr = {1, 5, 2, 6, 3, 7, 4};
        int[][] command = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        for (int x : T.solution(arr, command)) System.out.print(x + " ");
    }
}