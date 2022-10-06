
class Solution {
    public int[] solution(int n, long left, long right) {
        int[] result = new int[(int) (right - left + 1)];
        int ltY, ltX, rtY, rtX, idx = 0;

        ltY = (int) (left / (long) n);
        ltX = (int) (left % (long) n);
        rtY = (int) (right / (long) n);
        rtX = (int) (right % (long) n);

        for (int y = ltY; y <= rtY; y++) {
            for (int x = ltX; y == ltY && x < n; x++) result[idx++] = Math.max(y + 1, x + 1);
            for (int x = 0; y != ltY && y != rtY && x < n; x++) result[idx++] = Math.max(y + 1, x + 1);
            for (int x = 0; y == rtY && x <= rtX; x++) result[idx++] = Math.max(y + 1, x + 1);
        }
        return result;
    }
}