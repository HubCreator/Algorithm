class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for (int i = left; i <= right; i++) {
            if (i % Math.sqrt(i) == 0) answer -= i; // 제곱수인 경우 약수의 개수가 홀수
            else answer += i; // 제곱수가 아닌 경우 약수의 개수가 짝수
        }
        return answer;
    }
}