// 시간 복잡도 : O(n)
// 공간 복잡도 : O(n)
class Solution {

    public long solution(int[] sequence) {
        long[] arr = new long[sequence.length + 1];
        long min = 0, max = 0;

        for (int i = 0; i < sequence.length; i++) {
            arr[i + 1] = arr[i] + sequence[i] * (long) Math.pow(-1, i);
            min = Math.min(min, arr[i + 1]);
            max = Math.max(max, arr[i + 1]);
        }

        return max - min;
    }
}
