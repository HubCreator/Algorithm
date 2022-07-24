class Solution {
    public long solution(long n) {
        double sqrt = Math.sqrt(n);
        return (double)(sqrt % 1d) == 0d ?
                (long)((sqrt + 1) * (sqrt + 1)) :
                -1l;
    }
}