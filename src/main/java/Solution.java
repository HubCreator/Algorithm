import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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

    private static List<Point> points = new ArrayList<>();
    private static String[][] board;
    private static int n, m;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < T; i++) {
            answer.append("#").append(i + 1).append(" ");
            points.clear();
            answer.append(solution(br) ? "possible" : "impossible").append("\n");
        }
        System.out.println(answer);
    }

    private static boolean solution(BufferedReader br) throws IOException {
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        makeBoard(br);

        return bfs();
    }

    private static void makeBoard(BufferedReader br) throws IOException {
        board = new String[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = String.valueOf(str.charAt(j));
                if (!board[i][j].equals("?")) points.add(new Point(i, j, board[i][j]));
            }
        }
    }

    private static boolean bfs() {
        Queue<Point> queue = new LinkedList<>(points);
        while (!queue.isEmpty()) {
            Point poll = queue.poll();
            if (poll.mark.equals("!")) continue;
            board[poll.y][poll.x] = "!";
            for (int i = 0; i < 4; i++) {
                int ny = poll.y + dy[i];
                int nx = poll.x + dx[i];
                if (ny >= 0 && ny < n && nx >= 0 && nx < m && !board[ny][nx].equals("!")) {
                    if (board[ny][nx].equals("?")) {
                        String mark = poll.mark.equals("#") ? "." : "#";
                        queue.offer(new Point(ny, nx, mark));
                        board[ny][nx] = mark;
                    } else if (!board[ny][nx].equals(poll.mark)) {
                        queue.offer(new Point(ny, nx, board[ny][nx]));
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}