class Solution {
    public int[] solution(String s) {
        int round = 0, zeroCount = 0;
        while (!s.equals("1")) {
            round += 1;
            String result = s.replaceAll("0", "");
            zeroCount += s.length() - result.length();
            s = Integer.toBinaryString(result.length());
        }
        return new int[]{round, zeroCount};
    }
}
