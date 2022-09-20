class Solution {
    public int[][] solution(int[][] A, int[][] B) {
        int[][] answer = new int[A.length][B[0].length];
        if (A[0].length == B.length) {
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < B[0].length; j++) {
                    for (int k = 0; k < A[0].length; k++) {
                        answer[i][j] += A[i][k] * B[k][j];
                    }
                }
            }
        }
        return answer;
    }
}