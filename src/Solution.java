class Solution {
    public int solution(int n) {
        StringBuilder a = new StringBuilder();

        while (n > 0) {
            a.append(n % 3);
            n /= 3;
        }
        return Integer.parseInt(a.toString(), 3);
    }
}