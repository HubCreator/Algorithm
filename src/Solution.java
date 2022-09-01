import java.util.ArrayList;
import java.util.List;

class Point {
    int y, x;

    public Point(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

class Solution {
    public boolean solution(int[][] k, int[][] l) {
        List<Point> key = new ArrayList<>();
        List<List<Point>> entry = new ArrayList<>();
        int keySize = k.length, lockSize = l.length, lockCnt = 0;

        for (int i = 0; i < keySize; i++)
            for (int j = 0; j < keySize; j++)
                if (k[i][j] == 1) key.add(new Point(i, j));

        for (int[] arr : l)
            for (int x : arr)
                if (x == 0) lockCnt++;

        for (int m = 0; m < 4; m++) { // key 4 방향 회전
            entry.add(new ArrayList<>());
            for (Point p : key) {
                int tmp = p.x;
                p.x = p.y;
                p.y = keySize - 1 - tmp;
                entry.get(m).add(new Point(p.y, p.x));
            }
        }

        for (int i = -lockSize + 1; i < lockSize; i++) {
            for (int j = -lockSize + 1; j < lockSize; j++) {
                for (List<Point> points : entry) {
                    int cnt = 0;
                    for (Point p : points) {
                        int ny = p.y + i;
                        int nx = p.x + j;
                        if (ny >= 0 && ny < lockSize && nx >= 0 && nx < lockSize && (l[ny][nx] ^ 1) == 0) cnt++;
                    }
                    if (cnt == lockCnt) return true;
                }
            }
        }
        return false;
    }
}