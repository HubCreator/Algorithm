import java.util.*;

class Solution {
    public int zeroCount = 0;
    public int oneCount = 0;
    
    public int[] solution(int[][] arr) {
        dfs(arr, 0, 0, arr.length);
        return new int[]{zeroCount, oneCount};
    }
    
    public void dfs(int[][] arr, int y, int x, int size) {
        int zero = 0, one = 0;
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (arr[i][j] == 0) {
                    zero++;
                    continue;
                }
                one++;
            }
        }
        if (zero == 0) {
            oneCount++;
        } else if (one == 0) {
            zeroCount++;
        } else {
            int nSize = size / 2;
            dfs(arr, y, x, nSize);
            dfs(arr, y, x + nSize, nSize);
            dfs(arr, y + nSize, x, nSize);
            dfs(arr, y + nSize, x + nSize, nSize);
        }
    }
}