import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
            if (N == 1) {
                answer.append("#" + test_case + " " + 1 + "\n");
                continue;
            }
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
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j]) entry.add(new Point(i, j));
            }
        }
        int y = board.length;
        int x = board.length;
        // 좌 우 방향으로 수직선 상에 위치하는지 체크
        for (Point p : entry) {
            if ((y ^ p.y) == 0) return false;
            if ((x ^ p.x) == 0) return false;
            y = p.y;
            x = p.x;
        }

        // 대각선 방향으로 체크
        List<Point> tmp = new ArrayList<>();
        for (Point point : entry) {
            for (int i = -board.length; i <= board.length; i++) {
                if (i == 0) continue;
                Point p1 = new Point(point.y + i, point.x + i);
                Point p2 = new Point(point.y - i, point.x - i);
                if (!tmp.isEmpty() && tmp.contains(p1) && tmp.contains(p2)) return false;
                tmp.add(p1);
                tmp.add(p2);
            }
        }
        return true;
    }
}