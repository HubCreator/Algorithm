import java.util.StringTokenizer;

class Solution {
    public String solution(String s) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        StringTokenizer st = new StringTokenizer(s);
        while (st.hasMoreTokens()) {
            int target = Integer.parseInt(st.nextToken());
            min = Math.min(min, target);
            max = Math.max(max, target);
        }
        return min + " " + max;
    }
}
