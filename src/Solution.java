
class Solution {

    boolean isPrime(long v) {
        if (v == 0 || v == 1) return false;
        for (long i = 2; i < (long) Math.sqrt(v) + 1; i++)
            if (v % i == 0) return false;
        return true;
    }

    public int solution(int n, int k) {
        int answer = 0;
        String s = Long.toString(n, k);
        StringBuilder sb = new StringBuilder();

        if (s.charAt(s.length() - 1) != '0') s += '0';

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur != '0') sb.append(cur);
            else {
                if (isPrime(Long.parseLong(sb.toString()))) answer++;
                sb = new StringBuilder("0"); // 0 또는 1이 연달아 나오는 상황에서 sb가 초기화되어있지 않다면 런타임 에러 발생
            }
        }
        return answer;
    }
}