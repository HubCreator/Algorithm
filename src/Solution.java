class Solution {
    public int[] solution(String s) {
        int round = 0, cnt = 0;
        while(!s.equals("1")) {
            int len = s.length();
            // 1단계
            s = s.replaceAll("0", "");
            cnt += len - s.length();
            // 2단계
            s = Integer.toBinaryString(s.length());
            round++;
        }
        return new int[]{round, cnt};
    }
}