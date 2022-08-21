import java.util.Arrays;

class Solution {
    private int[] arr, pm, ch;
    private int n, m;

    private void dfs(int L) {
        if (L == m) {
            for (int x : pm) System.out.print(arr[x] + " ");
            System.out.println();
        } else {
            for (int i = 0; i < n; i++) {
                if (ch[i] == 0) {
                    ch[L] = 1;
                    pm[L] = i;
                    dfs(L + 1);
                    ch[L] = 0;
                }
            }
        }
    }

    public void solution(int _n, int _m, int[] _arr) {
        arr = _arr.clone();
        n = _n;
        m = _m;
        ch = new int[n];
        pm = new int[m];

        dfs(0);
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        T.solution(3, 2, new int[]{3, 6, 9});

    }
}