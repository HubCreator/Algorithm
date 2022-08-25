import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx = 0;

        for (int[] command : commands) {
            int s = command[0] - 1, e = command[1] - 1, k = command[2] - 1;
            int[] arr = Arrays.copyOfRange(array, s, e + 1);
            Arrays.sort(arr);
            answer[idx++] = arr[k];
        }
        return answer;
    }
}