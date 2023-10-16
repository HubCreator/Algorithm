import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int[] dy = new int[]{-1, 0, 1, 0};
    public int[] dx = new int[]{0, 1, 0, -1};

    public int solution(int[][] maps) {
        int answer = 0, n = maps.length, m = maps[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});

        while(!queue.isEmpty()) {
            int size = queue.size();
            answer++;
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                maps[poll[0]][poll[1]] = -1;
                if (poll[0] == n - 1 && poll[1] == m - 1) {
                    return answer;
                }
                for (int d = 0; d < 4; d++) {
                    int ny = poll[0] + dy[d];
                    int nx = poll[1] + dx[d];
                    if (ny >= 0 && ny < n &&
                            nx >= 0 && nx < m &&
                            maps[ny][nx] == 1) {
                        queue.offer(new int[]{ny, nx});
                    }
                }
            }

        }
        return -1;
    }
}
