import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int y, x;
    String mark;

    public Point(int y, int x, String mark) {
        this.y = y;
        this.x = x;
        this.mark = mark;
    }
}

public class Solution {

    private static int[] dy = {0, -1, 0, 1};
    private static int[] dx = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < T; i++) {
            answer.append("#").append(i + 1).append(" ");
            answer.append(solution(br) ? "possible" : "impossible").append("\n");
        }
        System.out.println(answer);
    }

    private static boolean solution(BufferedReader br) throws IOException {
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[][] board = makeBoard(n, m, br);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!board[i][j].equals("?")) {
                    if (!bfs(board, i, j)) return false;
                }
            }
        }
        return true;
    }

    private static String[][] makeBoard(int n, int m, BufferedReader br) throws IOException {
        String[][] board = new String[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = String.valueOf(str.charAt(j));
            }
        }
        return board;
    }

    private static boolean bfs(String[][] board, int row, int col) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(row, col, board[row][col]));
        while (!queue.isEmpty()) {
            Point poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = poll.y + dy[i];
                int nx = poll.x + dx[i];
                if (ny >= 0 && ny < row && nx >= 0 && nx < col) {
                    if (!board[ny][nx].equals(poll.mark)) {
                        board[ny][nx] = poll.mark.equals("#") ? "." : "#";
                        queue.add(new Point(ny, nx, board[ny][nx]));
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}