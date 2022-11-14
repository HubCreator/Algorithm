import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Point {
    int y, x;

    public Point(int y, int x) {
        this.y = y;
        this.x = x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return y == point.y && x == point.x;
    }

    @Override
    public int hashCode() {
        return Objects.hash(y, x);
    }
}

public class Solution {
    static StringBuilder answer = new StringBuilder();
    static boolean board[][];
    static int resultCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            resultCnt = 0;
            board = new boolean[N][N];
            dfs(board, 0);
            answer.append("#" + test_case + " " + resultCnt + "\n");
        }
        System.out.println(answer);
    }

    private static void dfs(boolean[][] board, int L) {
        // 기저 조건 (각 위치마다 8방향으로 뻗어나가며 경로에 다른 말이 없는지 확인)
        if (L == board.length) {
            if (isValid(board)) {
                resultCnt++;
            }
            return;
        }
        for (int i = 0; i < board.length; i++) {
            board[L][i] = true;
            dfs(board, L + 1);
            board[L][i] = false;
        }
    }

    private static boolean isValid(boolean[][] board) {
        List<Point> entry = new ArrayList<>();
        Set<Integer> ySet = new HashSet<>();
        Set<Integer> xSet = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j]) {
                    entry.add(new Point(i, j));
                    ySet.add(i);
                    xSet.add(j);
                }
            }
        }
        if (ySet.size() != board.length || xSet.size() != board.length) return false;
        for (Point p1 : entry) {
            for (Point p2 : entry) {
                if (p1.equals(p2)) continue;
                if (Math.abs((p1.y - p2.y) / (p1.x - p2.x)) == 1) return false;
            }
        }
        return true;
    }
}