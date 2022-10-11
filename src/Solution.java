class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        int curNum = 1, curIdx = p - 1, cnt = 0;
        sb.append(0);
        while (cnt < t) {
            for (int i = 0; i < m; i++)
                sb.append(Long.toString(curNum++, n)); // n 진수로 바꿈
            answer.append(sb.charAt(curIdx));
            cnt++;
            curIdx += m;
        }
        return answer.toString().toUpperCase();
    }
}