class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String line = Long.toString(n, k) + "0";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < line.length(); i++) {
            char curr = line.charAt(i);
            if (curr != '0') {
                sb.append(curr);
            } else {
                if (sb.length() > 0 && isPrime(sb.toString())) {
                    answer++;
                }
                sb = new StringBuilder();
            }
        }

        return answer;
    }

    private boolean isPrime(String input) {
        long i = Long.parseLong(input);
        if (i == 1) {
            return false;
        } else {
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
