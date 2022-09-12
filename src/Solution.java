class Solution {
    public int solution(int n) {
        int answer = 0;
        for (int i = 1; n - i * (i + 1) / 2 >= 0; i++) { // i = 자릿수
            int sum = i * (i + 1) / 2;
            if ((n - sum) % i == 0) answer++;
        }
        return answer;
    }
}