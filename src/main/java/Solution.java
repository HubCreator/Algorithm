import java.util.Arrays;

// 시간 복잡도 : O(n)
// 공간 복잡도 : O(n)
class Solution {

    public long solution(int[] sequence) {
        long[] arr = new long[sequence.length + 1];

        for (int i = 0; i < sequence.length; i++) {
            arr[i + 1] = arr[i] + sequence[i] * (long) Math.pow(-1, i);
        }

        return Arrays.stream(arr).max().getAsLong() - Arrays.stream(arr).min().getAsLong();
    }
}
