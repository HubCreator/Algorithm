class Solution {

    public int[][] solution(int[][] m1, int[][] m2) {
        int row = m1.length; // m1 행의 길이
        int col = m2[0].length; // m2 열의 길이
        int cnt = m2.length; // m2 행의 길이

        int[][] res = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                for (int k = 0; k < cnt; k++) {
                    res[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int[][] m1 = {
                {1, 2, 3},
                {4, 5, 6}
        };
        int[][] m2 = {
                {1, 2},
                {3, 4},
                {5, 6}
        };
        for (int[] ints : T.solution(m1, m2)) {
            for (int x : ints) System.out.print(x + " ");
            System.out.println();
        };

    }
}