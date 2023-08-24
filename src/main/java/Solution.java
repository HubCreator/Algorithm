class Solution {
    public int solution(int[][] triangle) {
        for (int i = triangle.length - 1; i >= 0; i--) {
            for (int j = triangle[i].length - 1; j >= 1; j--) {
                triangle[i - 1][j - 1] += Math.max(triangle[i][j - 1], triangle[i][j]);
            }
        }
        return triangle[0][0];
    }
}
