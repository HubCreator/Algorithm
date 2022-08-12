
class Solution {
    public int solution(int[][] tri) {
        int len = tri.length - 1;
        int[][] dis = new int[tri.length][tri.length];

        for (int col = 0; col < tri[len].length; col++) {
            dis[len][col] = tri[len][col];
        }

        int row = len - 1;
        while (row >= 0) {
            for (int col = 0; col < tri[row].length; col++) {
                dis[row][col] = tri[row][col] + Math.max(dis[row + 1][col], dis[row + 1][col + 1]);
            }
            row--;
        }

        return dis[0][0];
    }
}