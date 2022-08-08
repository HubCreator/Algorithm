class Solution {
    public int solution(int n) {
        if (n == 1) return 2;
        else if (n == 2) return 1;

        int c = 0, a = 1, b = 2;

        for (int i = 0; i < n - 2; i++) {
            c = (a + b) % 1000000007;
            a = b;
            b = c;
        }

        return c;
    }
}