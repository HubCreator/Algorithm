class Solution {
    int[] nums, pm, ch;
    int answer = Integer.MIN_VALUE;
    private void dfs(int L) {
        if (L == pm.length) {
            StringBuilder sb = new StringBuilder();
            for (int x : pm) sb.append(nums[x]);
            answer = Math.max(answer, Integer.parseInt(sb.toString()));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if(ch[i] == 0) {
                    ch[i] = 1;
                    pm[L] = i;
                    dfs(L + 1);
                    ch[i] = 0;
                }
            }
        }
    }

    public String solution(int[] numbers) {
        nums = numbers;
        pm = new int[numbers.length];
        ch = new int[numbers.length];
        dfs(0);
        return Integer.toString(answer);
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int[] arr = {1, 1, 1, 1, 1, 1, 1, 2, 2, 3};
        System.out.println(T.solution(arr));
    }
}