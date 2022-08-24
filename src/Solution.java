
class Solution {
    public int solution(String s) {
        int answer = s.length();

        for (int size = 1; size <= s.length() / 2; size++) {
            int idx = 0, length = s.length(), cnt = 1;
            String tmp = "";
            StringBuilder sb = new StringBuilder();
            while (idx <= s.length()) {
                int len = Math.min(idx + size, length);
                String substring = s.substring(idx, len);
                if (tmp.equals(substring)) cnt++;
                else {
                    if (cnt > 1) sb.append(cnt).append(tmp);
                    else sb.append(tmp);
                    cnt = 1;
                }
                idx += size;
                tmp = substring;
            }
            if (cnt > 1) sb.append(cnt).append(tmp);
            else sb.append(tmp);

            answer = Math.min(answer, sb.toString().length());
        }
        return answer;
    }
}