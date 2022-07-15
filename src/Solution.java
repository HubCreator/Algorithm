class Solution {
    public String solution(String s) {
        if(s.length() % 2 == 0) return new StringBuilder()
                .append(s.charAt(s.length() / 2 - 1))
                .append(s.charAt(s.length() / 2)).toString();
        else return new StringBuilder()
                .append(s.charAt(s.length() / 2)).toString();
    }
}