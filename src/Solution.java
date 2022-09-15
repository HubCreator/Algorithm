class Solution {
    public String solution(String num) {
        StringBuilder answer = new StringBuilder();
        int cnt = 0;
        for (int i = num.length() - 1; i >= 0; i--) {
            if (cnt >= 4) answer.append('*');
            else answer.append(num.charAt(i));
            cnt++;
        }
        return answer.reverse().toString();
    }
}