class Solution {
    public int solution(int num) {
        int answer = 0;
        long _num = (long) num;
        for(int i = 0; i < 500; i++)  {
            if(_num == 1) return answer;
            _num = (_num % 2 == 0) ? _num / 2 : (_num * 3) + 1;
            answer++;
        }
        return -1;
    }
}