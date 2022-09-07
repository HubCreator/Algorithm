class Solution {
    private boolean isAllZero(int[][] board) {
        boolean flag = true;
        for (int[] col : board) {
            for (int row : col) {
                if (row == 1) return false;
            }
        }
        return flag;
    }

    public int solution(int[][] board) {
        if (isAllZero(board)) return 0;
        int answer = Integer.MIN_VALUE;
        int maxSize = Math.min(board.length, board[0].length);
        for (int i = 1; i <= maxSize; i++) { // 정사각형의 size
            Loop1:
            for (int j = 0; j <= board.length - i; j++) { // y 좌표
                for (int k = 0; k <= board[j].length - i; k++) { // x 좌표
                    int sum = 0;
                    Loop2:
                    for (int l = j; l < j + i; l++) { // 해당 좌표로 부터 정사각형 범위 내에 있는 값들
                        for (int m = k; m < k + i; m++) {
                            if (board[l][m] == 0) break Loop2;
                            sum += board[l][m];
                        }
                    }
                    if (Math.pow(i, 2) == sum) {
                        answer = sum;
                        break Loop1;
                    }
                }
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        Solution T = new Solution();
        int[][] arr = {{0, 0, 1, 1}, {1, 1, 1, 1}};
        System.out.println(T.solution(arr));
    }
}