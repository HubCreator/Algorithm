class Solution {
    public int[][] solution(int[][] a, int[][] b) {
        int[][] answer = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) answer[i] = a[i].clone();

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                answer[i][j] += b[i][j];
            }
        }
        return answer;
    }
}