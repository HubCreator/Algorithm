import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr) {
        if (arr.length == 1) return new int[]{-1};

        int[] answer = new int[arr.length - 1];
        int min = Arrays.stream(arr).min().getAsInt(), idx = 0;

        for (int x : arr) if (x != min) answer[idx++] = x;

        return answer;
    }
}