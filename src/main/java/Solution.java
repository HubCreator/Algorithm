class Solution {

    private static final int RADIX = 3;

    public int solution(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            sb.append(n % RADIX);
            n /= RADIX;
        }
        return Integer.parseInt(sb.toString(), 3);
    }
}