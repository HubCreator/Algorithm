
class Solution {
    public String solution(String s) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        String[] arr = s.split(" ");
        for (String str : arr) {
            int x = Integer.parseInt(str);
            min = Math.min(min, x);
            max = Math.max(max, x);
        }
        return min + " " + max;
    }
}