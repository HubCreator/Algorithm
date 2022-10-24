import java.util.Arrays;

class Solution {
    public static final int N = 4;
    static int[][] cache;

    private static void initCache(int[][] cache) {
        for (int[] arr : cache) {
            Arrays.fill(arr, -1);
        }
    }

    private static int move(int[][] land, int row, int col) {
        if (row == land.length - 1) return cache[row][col] = land[row][col]; // 기저 조건
        if (cache[row][col] != -1) return cache[row][col]; // 캐시

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
        initCache(cache);
        for (int i = 0; i < N; i++) {
            result = Math.max(result, move(land, 0, i));
            for (int[] ints : cache) {
                for (int x : ints) {
                    System.out.print(x + " ");
                }
                System.out.println();
            }
            System.out.println("result = " + result);
            System.out.println();
        }
        return result;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int[][] arr = {{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}};
        System.out.println(T.solution(arr));
    }
}
