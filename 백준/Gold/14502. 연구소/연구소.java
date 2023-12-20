import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int[] dy = {-1, 0, 1, 0};
    public static int[] dx = {0, 1, 0, -1};
    public static int[][] board;
    public static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        List<int[]> blanks = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int target = Integer.parseInt(st2.nextToken());
                board[i][j] = target;
                if (target == 0) {
                    blanks.add(new int[]{i, j});
                }
            }
        }

        int[] pm = new int[3];
        boolean[] check = new boolean[blanks.size()];
        dfs(blanks, check, pm, 0);
        System.out.print(answer);
    }

    private static void dfs(List<int[]> blanks, boolean[] check, int[] pm, int level) {
        if (level == pm.length) {
            int[][] copyBoard = new int[board.length][];
            for (int i = 0; i < board.length; i++) {
                copyBoard[i] = Arrays.copyOf(board[i], board[i].length);
            }
            for (int idx : pm) {
                int[] coord = blanks.get(idx);
                copyBoard[coord[0]][coord[1]] = 1;
            }
            for (int i = 0; i < copyBoard.length; i++) {
                for (int j = 0; j < copyBoard[i].length; j++) {
                    if (copyBoard[i][j] == 2) {
                        Queue<int[]> queue = new ArrayDeque<>();
                        queue.offer(new int[]{i, j});
                        while (!queue.isEmpty()) {
                            int[] poll = queue.poll();
                            for (int d = 0; d < 4; d++) {
                                int ny = poll[0] + dy[d];
                                int nx = poll[1] + dx[d];
                                if (ny >= 0 && ny < copyBoard.length &&
                                        nx >= 0 && nx < copyBoard[0].length &&
                                        copyBoard[ny][nx] == 0) {
                                    queue.offer(new int[]{ny, nx});
                                    copyBoard[ny][nx] = 2;
                                }
                            }
                        }
                    }
                }
            }
            int result = 0;
            for (int[] row : copyBoard) {
                for (int el : row) {
                    if (el == 0) {
                        result++;
                    }
                }
            }
            answer = Math.max(answer, result);
        } else {
            for (int i = 0; i < blanks.size(); i++) {
                if (!check[i]) {
                    check[i] = true;
                    pm[level] = i;
                    dfs(blanks, check, pm, level + 1);
                    check[i] = false;
                }
            }
        }
    }
}