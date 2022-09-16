public class Solution {
    int[] ch, pm;

    private void dfs(int L, int[] arr) {
        if (L == pm.length) {
            for (int x : pm) System.out.print(arr[x] + " ");
            System.out.println();
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    pm[L] = i;
                    dfs(L + 1, arr);
                    ch[i] = 0;
                }
            }
        }
    }

    public void solution(int[] arr, int r) {
        pm = new int[r];
        ch = new int[arr.length];
        dfs(0, arr);
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int r = 2;
        int[] arr = {3, 6, 9};
        T.solution(arr, r);
    }
}