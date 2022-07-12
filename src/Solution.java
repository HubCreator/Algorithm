class Solution {
    public String solution(int n) {

        return new String(new char[n / 2 + 1]).replace("\0", "수박").substring(0, n);
    }
}