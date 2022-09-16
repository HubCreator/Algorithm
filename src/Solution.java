public class Solution {
    int[] ch;

    private void dfs(int L, int n, int r) {
        if (L == r) {
            for (int x : ch) System.out.print(x + " ");
            System.out.println();
        } else {
            for (int i = 1; i <= n; i++) {
                ch[L] = i;
                dfs(L + 1, n, r);
            }
        }
    }

    public void solution(int n, int r) {
        ch = new int[r];
        dfs(0, n, r);
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        T.solution(3, 2);
    }
}