class Solution {
    int answer = 0;

    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }

    public void dfs(int[] numbers, int target, int sum, int level) {
        if (numbers.length == level) {
            if (sum == target) answer += 1;
        } else {
            dfs(numbers, target, sum + numbers[level], level + 1);
            dfs(numbers, target, sum - numbers[level], level + 1);
        }
    }
}
