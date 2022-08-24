class Solution {
    int zero = 0, one = 0;

    private void recursive(int y, int x, int[][] board, int size) {
        int[] sum = new int[4];
        if (size == 0) return;
        int len = size / 2;
        for (int i = y; i < y + len; i++) {
            for (int j = x; j < x + len; j++) {
                sum[0] += board[i][j];
            }
            for (int j = x + len; j < x + size; j++) {
                sum[1] += board[i][j];
            }
        }

        for (int i = y + len; i < y + size; i++) {
            for (int j = x; j < x + len; j++) {
                sum[2] += board[i][j];
            }
            for (int j = x + len; j < x + size; j++) {
                sum[3] += board[i][j];
            }
        }


        if (sum[0] == 0) zero++;
        else if (sum[0] == Math.pow(len, 2)) one++;
        else recursive(y, x, board, size / 2);

        if (sum[1] == 0) zero++;
        else if (sum[1] == Math.pow(len, 2)) one++;
        else recursive(y, x + len, board, size / 2);

        if (sum[2] == 0) zero++;
        else if (sum[2] == Math.pow(len, 2)) one++;
        else recursive(y + len, x, board, size / 2);

        if (sum[3] == 0) zero++;
        else if (sum[3] == Math.pow(len, 2)) one++;
        else recursive(y + len, x + len, board, size / 2);
    }

    public int[] solution(int[][] arr) {
        int zero = 0, one = 0, cnt = 0;
        for (int[] y : arr) {
            for (int x : y) {
                cnt++;
                if (x == 1) one++;
                else zero++;
            }
        }
        if (zero == cnt) return new int[]{1, 0};
        else if (one == cnt) return new int[]{0, 1};
        else recursive(0, 0, arr, arr.length);

        return new int[]{this.zero, this.one};
    }
}