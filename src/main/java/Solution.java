class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] check = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!check[i]) {
                dfs(computers, check, i);
                answer++;
            }
        }
        return answer;
    }

    void dfs(int[][] computers, boolean[] check, int start) {
        check[start] = true;
        for (int i = 0; i < computers.length; i++) {
            if (computers[start][i] == 1 && !check[i]) {
                dfs(computers, check, i);
            }
        }
    }
}
