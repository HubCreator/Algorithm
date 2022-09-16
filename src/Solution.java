
class Solution {
    int[] ch;
    int answer = Integer.MIN_VALUE;

    private void dfs(int L, int c, int[] arr) {
        if (L == arr.length) {
            int sum = 0;
            for (int i = 0; i < ch.length; i++) {
                if (ch[i] == 1) sum += arr[i];
            }
            if (sum <= c) answer = Math.max(answer, sum);
        } else {
            ch[L] = 1;
            dfs(L + 1, c, arr);
            ch[L] = 0;
            dfs(L + 1, c, arr);
        }
    }

    public int solution(int c, int[] arr) {
        ch = new int[c];
        dfs(0, c, arr);

        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int c = 259;
        int[] arr = {81, 58, 42, 33, 61};
        System.out.println(T.solution(c, arr));
    }
}