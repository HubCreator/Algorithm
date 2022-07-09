class Solution {
    public int getDividedIdx(String str) {
        int ch = 0;
        for (int i = 0; i < str.length(); i++) {
            ch += (str.charAt(i) == '(') ? 1 : -1;
            if (ch == 0) return i + 1;
        }
        return -1;
    }

    public boolean isCorrect(String str) {
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            cnt += str.charAt(i) == '(' ? 1 : -1;
            if (cnt < 0) return false;
        }
        return cnt == 0;
    }

    private String change(String u, String v) {
        StringBuilder s = new StringBuilder("(" + getAnswer(v) + ")");
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < u.length() - 1; i++) {
            sb.append(u.charAt(i) == ')' ? '(' : ')');
        }
        s.append(sb);
        return s.toString();
    }

    private String getAnswer(String w) {
        if (w.equals("")) return "";
        int idx = getDividedIdx(w);
        String u = w.substring(0, idx);
        String v = w.substring(idx);
        if (isCorrect(u)) return u + getAnswer(v);
        else return change(u, v);
    }

    public String solution(String p) {
        return getAnswer(p);
    }
}