
class Solution {
    public int[] solution(int n, long left, long right) {
        int[] result = new int[(int) (right - left + 1)];
        long ltY, ltX, rtY, rtX;
        int idx = 0;

        ltY = (left / (long) n);
        ltX = (left % (long) n);
        rtY = (right / (long) n);
        rtX = (right % (long) n);

        for (long y = ltY; y <= rtY; y++) {
            for (long x = ltX; y == ltY && x < n; x++) result[idx++] = (int) Math.max(y + 1, x + 1);
            for (long x = 0; y != ltY && y != rtY && x < n; x++) result[idx++] = (int) Math.max(y + 1, x + 1);
            for (long x = 0; y == rtY && x <= rtX; x++) result[idx++] = (int) Math.max(y + 1, x + 1);
        }

        return result;
    }
}