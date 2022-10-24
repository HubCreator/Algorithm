
class Solution {
    public static final int N = 4;
    static int[][] cache;

    private static int move(int[][] land, int row, int col) {
        if (row == land.length - 1) return cache[row][col] = land[row][col]; // 기저 조건
        if (cache[row][col] != 0) return cache[row][col]; // 캐시

        for (int i = 0; i < N; i++) {
            if (i != col) {
                cache[row][col] = Math.max(cache[row][col], land[row][col] + move(land, row + 1, i));
            }
        }
        return cache[row][col];
    }

    static int solution(int[][] land) {
        cache = new int[land.length][N];
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            result = Math.max(result, move(land, 0, i));
        }
        return result;
    }
}
