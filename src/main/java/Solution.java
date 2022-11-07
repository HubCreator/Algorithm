class Solution {
    public int solution(int n) {
        int bitCnt1 = Integer.bitCount(n);
        int bitCnt2 = -1;
        int answer = n;
        while (bitCnt1 != bitCnt2) {
            bitCnt2 = Integer.bitCount(++answer);
        }
        return answer;
    }
}