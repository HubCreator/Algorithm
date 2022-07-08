class Solution {
    public long getGCD(int _a, int _b) {
        long a = _a, b = _b, c = 0;
        while (b != 0) {
            c = a % b;
            a = b;
            b = c;
        }
        return a;
    }
    public long solution(int w, int h) {
        return ((long) w * h) - (w + h - getGCD(w, h));
    }
}