class Solution {
    public int[] solution(int n, long left, long right) {
        int[] result = new int[(int) ((right - left) + 1)];
        int ltY, rtY, idx = 0;

        ltY = (int) (left / n);
        rtY = (int) (right / n);

        for (int y = ltY; y <= rtY; y++) {
            for (int x = 0; x < n; x++) {
                if (((long) y * n + x >= left && (long) y * n + x <= right)) {
                    result[idx++] = Math.max(y, x) + 1;
                }
            }
        }
        return result;
    }
}