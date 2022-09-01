class Solution {
    private int dfs(int k, int[][] dungeons) {
        int cnt = 0;
        for (int[] dungeon : dungeons) {
            int required = dungeon[0];
            int using = dungeon[1];
            if (k >= required) {
                dungeon[0] = Integer.MAX_VALUE; // 해당 던전을 중복하여 돌지 않도록 체크
                cnt = Math.max(cnt, dfs(k - using, dungeons) + 1);
                dungeon[0] = required; // 해당 던전을 다시 돌 수 있도록 원복
            }
        }
        return cnt;
    }

    public int solution(int k, int[][] dungeons) {
        return dfs(k, dungeons); // 전역변수를 두지 않고, 매개변수로 넘기는 것도 나름 깔끔하네
    }
}