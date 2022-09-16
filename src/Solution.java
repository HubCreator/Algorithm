public class Solution {
    int answer = Integer.MAX_VALUE;

    private void dfs(int L, int sum, int[] arr, int m) {
        if (sum > m || L >= answer) return;
        if (sum == m) {
            answer = Math.min(answer, L);
        } else {
            for (int x : arr) {
                dfs(L + 1, sum + x, arr, m);
            }
        }
    }

    public int solution(int[] arr, int m) {
        dfs(0, 0, arr, m);

        return answer;
    }


    public static void main(String[] args) {
        Solution T = new Solution();
        int[] arr = {1, 2, 5};
        int m = 15;
        System.out.println(T.solution(arr, m));
    }
}