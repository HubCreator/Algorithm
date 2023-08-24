class Solution {
    private int answer = Integer.MIN_VALUE;

    public int solution(int[][] triangle) {
        dfs(triangle, triangle[0][0], 0, 1);
        return answer;
    }

    private void dfs(int[][] triangle, int sum, int col, int level) {
        if (level == triangle.length) {
            answer = Math.max(answer, sum);
        } else {
            dfs(triangle, sum + triangle[level][col], col, level + 1);
            dfs(triangle, sum + triangle[level][col + 1], col + 1, level + 1);
        }
    }
}
