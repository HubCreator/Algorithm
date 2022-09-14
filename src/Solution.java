class Solution {
    public int solution(int n) {
        int cnt1 = 0, cur = n + 1;
        String s = Long.toBinaryString(n);
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) == '1') cnt1++;
        while (true) {
            int cnt2 = 0;
            String t = Long.toBinaryString(cur);
            for (int i = 0; i < t.length(); i++)
                if (t.charAt(i) == '1') cnt2++;
            if (cnt1 == cnt2) break;
            cur++;
        }
        return cur;
    }
}