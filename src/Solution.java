class Solution {
    public int solution(String s) {
        int answer = s.length();
        int winSize = 1;

        while (s.length() / 2 >= winSize) {
            StringBuilder str = new StringBuilder(s);
            int cnt = 1;
            StringBuilder sb = new StringBuilder();
            String win = str.substring(0, winSize); // 초기 윈도우
            StringBuilder sub = new StringBuilder();
            for (int i = winSize; i <= str.length() - winSize; ) {
                sub = new StringBuilder(str.substring(i, i + winSize));
                if (win.equals(sub.toString())) cnt++;
                else {
                    if (cnt > 1) {
                        sb.append(cnt);
                        cnt = 1;
                    }
                    sb.append(win);
                }
                win = sub.toString();
                i += winSize;
                if (i + winSize > str.length()) {
                    StringBuilder tmp = new StringBuilder();
                    for (int k = i; k < str.length(); k++) sb.append(str.charAt(k));
                    sb.append(tmp);
                }
            }
            if (cnt > 1) sb.append(cnt);
            sb.append(sub);
            System.out.println(sb);
            answer = Math.min(answer, sb.length());
            winSize++;
        }
        return answer;
    }
}