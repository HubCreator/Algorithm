class Solution {
    // 제한 시간 안에 얻을 수 있는 최대 점수 구하기
    int[] ch;
    int answer = Integer.MIN_VALUE;

    private void dfs(int L, int m, int[][] arr) {
        if (L == arr.length) {
            int time = 0, score = 0;
            for (int i = 0; i < ch.length; i++) {
                if (ch[i] == 1) {
                    score += arr[i][0];
                    time += arr[i][1];
                }
            }
            if (time <= m) answer = Math.max(answer, score);
        } else {
            ch[L] = 1;
            dfs(L + 1, m, arr);
            ch[L] = 0;
            dfs(L + 1, m, arr);
        }
    }

    public int solution(int m, int[][] arr) {
        ch = new int[arr.length];
        dfs(0, m, arr);

        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int m = 20;
        int[][] arr = {
                {10, 5}, // 점수와 소요 시간
                {25, 12},
                {15, 8},
                {6, 3},
                {7, 4}
        };
        System.out.println(T.solution(m, arr));
    }
}