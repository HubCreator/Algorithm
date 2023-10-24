class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder line = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n * t * m; i++) {
            line.append(Long.toString(i, n));
        }
        for (int i = 0; i < line.length(); i++) {
            if (answer.length() >= t) {
                break;
            }
            if (i % m == p - 1) {
                answer.append(Character.toUpperCase(line.charAt(i)));
            }
        }
        return answer.toString();
    }
}
