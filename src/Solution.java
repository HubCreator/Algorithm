class Solution {
    int[] nums, ch;
    int t, answer = 0;

    private void dfs(int L) {
        if (L == nums.length) {
            int sum = 0;
            for (int i = 0; i < ch.length; i++) {
                if(ch[i] == 1) sum -= nums[i];
                else sum += nums[i];
            }
            if(sum == t) answer++;
        } else {
            ch[L] = 0;
            dfs(L + 1);
            ch[L] = 1;
            dfs(L + 1);
        }
    }

    public int solution(int[] numbers, int target) {
        nums = numbers;
        ch = new int[numbers.length];
        t = target;
        dfs(0);
        return answer;
    }
}