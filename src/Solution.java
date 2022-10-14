class Solution {

    int[][] board;
    int[][] dis;

    private int dfs(int row, int col) {
        if (row >= board[0].length || col >= board.length || board[col][row] == -1) return 0;
        if (dis[col][row] > 0) return dis[col][row];
        return dis[col][row] = (dfs(row + 1, col) + dfs(row, col + 1)) % 1000000007;
    }

    public int solution(int m, int n, int[][] puddles) {
        board = new int[n + 1][m + 1];
        dis = new int[n + 2][m + 2];
        for (int[] puddle : puddles) board[puddle[1]][puddle[0]] = -1;

        dis[n][m] = 1;
        return dfs(1, 1);
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        System.out.println(T.solution(4, 3, new int[][]{{2, 2}}));
    }
}