class Solution {
    public int solution(int[][] sizes) {
        int a = Integer.MIN_VALUE, b = Integer.MIN_VALUE;

        for (int[] size : sizes) a = Math.max(a, Math.max(size[0], size[1]));
        for (int[] size : sizes) {
            int tmp = Math.min(size[0], size[1]);
            b = Math.max(b, tmp);
        }
        return a * b;
    }
}