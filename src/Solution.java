class Solution {
    public long solution(int price, int money, int count) {
        return Math.max((long) count * (count + 1) / 2 * price - money, 0);
    }
}