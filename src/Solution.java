import java.util.Arrays;

class Solution {
    int[] unf;

    private int find(int v) {
        if (v == unf[v]) return unf[v];
        else return unf[v] = find(unf[v]);
    }

    private void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if(fa != fb) unf[fa] = fb;
    }

    public int solution(int n, int[][] links) {
        unf = new int[n];
        for (int i = 0; i < n; i++) unf[i] = i;
        for (int i = 0; i < links.length; i++) {
            for (int j = 0; j < links[i].length; j++) {
                if (i == j) continue;
                if (links[i][j] == 1) union(i, j);
            }
        }

        return Arrays.stream(unf).map(m -> find(m)).distinct().toArray().length;
    }
}