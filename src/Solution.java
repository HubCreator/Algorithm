class Solution {
    public int solution(int _num) {
        int answer = 0;
        long num = _num;
        for (int i = 0; i < 500; i++) {
            if (num == 1) return answer;
            num = (num % 2 == 0) ? num / 2 : (num * 3) + 1;
            answer++;
        }
        return -1;
    }
}