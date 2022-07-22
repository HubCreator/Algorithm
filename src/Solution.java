class Solution {
    int dfs(int k, int[][] dungeons) {
        int cnt = 0;
        for (int[] d : dungeons) {
            int initialTired = d[0], needTired = d[1];
            if (initialTired <= k) {
                d[0] = Integer.MAX_VALUE;
                cnt = Math.max(cnt, dfs(k - needTired, dungeons) + 1);
                d[0] = initialTired;
            }
        }
        return cnt;
    }

    public int solution(int k, int[][] dungeons) {
        return dfs(k, dungeons);
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int k = 80;
        int[][] dungeons = {
                {80, 20},
                {50, 40},
                {30, 10}
        };
        System.out.println(T.solution(k, dungeons));
    }
}