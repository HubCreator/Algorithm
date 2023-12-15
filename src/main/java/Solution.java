class Solution {
    public int answer = Integer.MIN_VALUE;

    int solution(int[][] land) {
        for (int i = 0; i < 4; i++) {
            dfs(land, i, land[0][i], 0);
        }

        return answer;
    }

    public void dfs(int[][] land, int column, int sum, int depth) {
        if (depth == land.length) {
            answer = Math.max(answer, sum);
        } else {
            int index = Integer.MIN_VALUE, max = Integer.MIN_VALUE;
            for (int i = 0; i < land[depth].length; i++) {
                int t = land[depth][i];
                if (column != i && max <= t) {
                    max = t;
                    index = i;
                }
            }
            dfs(land, index, sum + max, depth + 1);
        }
    }
}