class Solution {

    int[][] board;
    int[][] dis;

    private void dfs(int x, int y) {
        if (x > dis[0].length - 1 || y > dis.length - 1 || board[y][x] == -1) return;
        dis[y][x] = (dis[y][x - 1] + dis[y - 1][x]) % 1000000007;
        dfs(x, y + 1);
        dfs(x + 1, y);
    }

    public int solution(int m, int n, int[][] puddles) {
        board = new int[n + 1][m + 1];
        dis = new int[n + 1][m + 1];
        for (int[] puddle : puddles) board[puddle[1]][puddle[0]] = -1;

        dis[0][1] = 1;
        dfs(1, 1);
        return dis[n][m];
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(4, 3, new int[][]{{2, 2}}));
    }
}