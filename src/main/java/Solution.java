class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        boolean[][] graph = new boolean[n + 1][n + 1];
        int[] prize = new int[n + 1];

        for (int[] result : results) {
            graph[result[0]][result[1]] = true;
        }

        for (int k = 1; k < n + 1; k ++) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if (!graph[i][j] && graph[i][k] && graph[k][j]) {
                        graph[i][j] = true;
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++){
            int cnt = 0;
            for (int j = 1; j <= n; j++){
                if (graph[i][j] || graph[j][i]) cnt++;
            }
            if (cnt == (n - 1)) answer++;
        }
        return answer;
    }
}
