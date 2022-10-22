class Solution {

    public static final int COL_LEN = 4;

    public static int solution(int[][] land) {
        int answer = 0;
        return logic(land, answer);
    }

    private static int logic(int[][] land, int answer) {
        for (int i = 1; i < land.length; i++) {
            int[] priorRow = land[i - 1]; // 이전 행의 배열
            for (int j = 0; j < COL_LEN; j++) {
                land[i][j] += getMaxElement(priorRow, j);
                if (i == land.length - 1) {
                    answer = Math.max(answer, land[i][j]);
                }
            }
        }
        return answer;
    }

    private static int getMaxElement(int[] priorRow, int col) {
        int max = 0;
        for (int k = 0; k < COL_LEN; k++) { // 매 번 구하는게 최선인가..?
            if (k != col && max < priorRow[k]) {
                max = priorRow[k];
            }
        }
        return max;
    }
}