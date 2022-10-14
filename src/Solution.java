class Solution {

    int[][] board;
    long[][] dis;

    private void dfs(int x, int y) {
        if (x <= 0 || y <= 0 || board[y][x] == -1) return;
        dis[y][x] = (dis[y][x + 1] + dis[y + 1][x]) % 1000000007;
        dfs(x, y - 1);
        dfs(x - 1, y);
    }

    public int solution(int m, int n, int[][] puddles) {
        board = new int[n + 1][m + 1];
        dis = new long[n + 2][m + 2];
        for (int[] puddle : puddles) board[puddle[1]][puddle[0]] = -1;

        dis[n + 1][m] = 1;
        dfs(m, n);
        return (int) dis[1][1];
    }
}