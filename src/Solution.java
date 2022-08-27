class Solution {
    public boolean solution(String s) {
        return s.matches("[0-9]{4}") || s.matches("[0-9]{6}");
    }
}