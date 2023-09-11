class Solution {
    public int answer = -1;

    public int solution(int k, int[][] dungeons) {
        boolean[] check = new boolean[dungeons.length];
        dfs(k, dungeons, check, 0);
        return answer;
    }

    public void dfs(int k, int[][] dungeons, boolean[] check, int level) {
        if (k < 0) {
            return;
        }
        if (level == check.length) {
            int count = 0;
            for (boolean ch : check) {
                if (ch) count++;
            }
            answer = Math.max(answer, count);
        } else {
            for (int i = 0; i < check.length; i++) {
                if (!check[i] && k >= dungeons[i][0]) {
                    check[i] = true;
                    dfs(k - dungeons[i][1], dungeons, check, level + 1);
                    check[i] = false;
                } else {
                    dfs(k, dungeons, check, level + 1);
                }
            }
        }
    }
}
