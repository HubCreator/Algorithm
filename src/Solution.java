class Solution {
    private int getGCD(int a, int b) {
        return a < b ? b % a : a % b;
    }

    public int[] solution(int _n, int _m) {
        int n = _n, m = _m;

        while (n != 0 && m != 0) {
            int val = getGCD(n, m);
            if (n < m) m = val;
            else n = val;
        }
        int max = Math.max(n, m);
        return new int[]{max, _n * _m / max};
    }
}