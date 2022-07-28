class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    arr[i][j] = 0;
                    continue;
                }
                arr[i][j] = 10000000;
            }
        }
        for (int[] r : road) {
            int v1 = r[0] - 1;
            int v2 = r[1] - 1;
            int cost = r[2];

            arr[v1][v2] = Math.min(arr[v1][v2], cost);
            arr[v2][v1] = Math.min(arr[v2][v1], cost);
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }

        for (int j = 0; j < arr.length; j++) {
            if (arr[0][j] <= K) answer++;
        }
        return answer;
    }
}