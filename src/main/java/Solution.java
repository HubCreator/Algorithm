public class Solution {
    public int solution(int n) {
        int answer = 0;
        while (n > 0) {
            System.out.println(n);
            if (n % 2 == 1) {
                answer += 1;
                n -= 1;
            }
            n /= 2;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(5));
    }
}
