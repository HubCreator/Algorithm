class Solution {
    int solution(int[][] land) {
        int answer = 0;

        for (int i = 1; i < land.length; i++) {
            int[] tmp = land[i - 1].clone();
            for (int j = 0; j < 4; j++) {
                int max = 0;
                for (int k = 0; k < 4; k++) {
                    if (k != j && max < tmp[k])
                        max = tmp[k];
                }
                land[i][j] += max;
                if (i == land.length - 1) {
                    answer = Math.max(answer, land[i][j]);
                }
            }
        }
        return answer;
    }
}