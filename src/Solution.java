class Solution {

    public int gcd (int a, int b) {
        return a < b ? b % a : a % b;
    }

    public int[] solution(int _n, int _m) {
        int[] answer = new int[2];
        int n = _n;
        int m = _m;

        while (n != 0 && m != 0) {
            int v = gcd(n, m);
            if (n < m) m = v;
            else n = v;
        }
        answer[0] = Math.max(n, m);
        answer[1] = _n * _m / answer[0];

        return answer;
    }
}