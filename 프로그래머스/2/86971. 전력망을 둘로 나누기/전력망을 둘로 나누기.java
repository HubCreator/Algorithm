import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    int answer = Integer.MAX_VALUE;
    boolean[][] board;

    public int solution(int n, int[][] wires) {
        board = new boolean[n + 1][n + 1];
        for (int[] wire : wires) {
            board[wire[0]][wire[1]] = true;
            board[wire[1]][wire[0]] = true;
        }

        for (int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];
            board[a][b] = false;
            board[b][a] = false;
            answer = Math.min(answer, Math.abs(bfs(a, n) - bfs(b, n)));
            board[a][b] = true;
            board[b][a] = true;
        }
        return answer;
    }

    public int bfs(int t, int n) {
        Queue<Integer> queue = new ArrayDeque<>();
        int count = 0;
        boolean[][] copied = new boolean[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                copied[i][j] = board[i][j];
                copied[j][i] = board[j][i];
            }
        }

        queue.offer(t);
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            count++;
            for (int i = 1; i <= n; i++) {
                if (copied[poll][i]) {
                    copied[poll][i] = false;
                    copied[i][poll] = false;
                    queue.offer(i);
                }
            }
        }
        return count;
    }
}