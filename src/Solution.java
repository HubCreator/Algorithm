class Solution {
    int one = 0, zero = 0;

    // s : start, e : end, m : mid
    void press(int[][] arr, int xs, int xe, int ys, int ye) {
        int cnt = 0, max = (int) Math.pow(xe - xs, 2);
        for (int i = xs; i < xe; i++) {
            for (int j = ys; j < ye; j++) {
                cnt += arr[i][j];
            }
        }
        if (cnt == 0) zero++;
        else if (cnt == max) one++;
        else {
            int xm = (xs + xe) / 2;
            int ym = (ys + ye) / 2;
            press(arr, xs, xm, ys, ym);
            press(arr, xm, xe, ys, ym);
            press(arr, xs, xm, ym, ye);
            press(arr, xm, xe, ym, ye);
        }
    }

    public int[] solution(int[][] arr) {
        press(arr, 0, arr.length, 0, arr.length);
        return new int[]{zero, one};
    }
}