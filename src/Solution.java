class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        String s = String.valueOf(x);
        int sum = 0;
        for(int i = 0; i < s.length(); i++) {
            sum += Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        return x % sum == 0;
    }
}