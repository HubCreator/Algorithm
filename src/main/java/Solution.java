class Solution {
    public int solution(int n, int a, int b) {
        int round = 1;
        while (Math.abs(a - b) != 1 || Math.max(a, b) % 2 != 0) {
            round++;
            a = (a + 1) / 2;
            b = (b + 1) / 2;
        }

        return round;
    }
}
