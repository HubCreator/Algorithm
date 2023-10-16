class Solution {
    public int solution(int n) {
        int lt = 1, sum = 0, answer = 0;
        for (int rt = 1; rt <= n; rt++) {
            sum += rt;
            if (sum == n) {
                answer++;
            } else if (sum > n) {
                while (sum > n) {
                    sum -= lt++;
                }
                if (sum == n) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
