class Solution {
    public int[] solution(int n, long left, long right) {
        if (left == right) return new int[]{};

        int[] result = new int[(int) ((right - left) + 1)];
        long ltY, ltX, rtY, rtX, tmp;
        int idx = 0;

        ltY = (left / n);
        ltX = (left % n);
        rtY = (right / n);
        rtX = (right % n);

        for (long y = ltY; y <= rtY; y++) {
            tmp = ltX;
            while (y == ltY && tmp < n) {
                result[idx++] = (int) Math.max(tmp++, y) + 1;
            }
            tmp = 0;
            while (y != ltY && y != rtY && tmp < n) {
                result[idx++] = (int) Math.max(tmp++, y) + 1;
            }
            tmp = 0;
            while (y == rtY && tmp <= rtX) {
                result[idx++] = (int) Math.max(tmp++, y) + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        for (int x : T.solution(3, 2, 5)) {
            System.out.print(x + " ");
        }
    }
}