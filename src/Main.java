import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] ch;
    static char[][] board;
    static int c, n;
    static String[] arr;
    static int[] answer;
    int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    private boolean DFS(int y, int x, String word) {
        if (y < 0 || y >= 5 || x < 0 || x >= 5) return false; // 범위 조건
        if (board[y][x] != word.charAt(0)) return false; // 해당 위치에 첫 번째 문자가 없으면 false
        if (word.length() == 1) return true; // 위의 조건을 다 뚫고 str이 하나만 남았다면 true
        for (int k = 0; k < 8; k++) { // 8방향으로 찾음
            int ny = y + dy[k];
            int nx = x + dx[k];
            if (DFS(ny, nx, word.substring(1))) return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        c = Integer.parseInt(br.readLine());
        board = new char[5][5];
        ch = new int[5][5];
        answer = new int[5];
        for (int i = 0; i < 5; i++) {
            String s = br.readLine();
            for (int j = 0; j < 5; j++) {
                board[i][j] = s.charAt(j);
            }
        }
        n = Integer.parseInt(br.readLine());
        arr = new String[n];
        for (int i = 0; i < n; i++) arr[i] = br.readLine();
        for (int i = 0; i < n; i++) {
            boolean result = false;
            Loop1:
            for (int a = 0; a < 5; a++) {
                for (int b = 0; b < 5; b++) {
                    if (board[a][b] == arr[i].charAt(0)) {
                        result = T.DFS(a, b, arr[i]);
                        if (result) {
                            break Loop1;
                        }
                    }
                }
            }
            System.out.println(arr[i] + " " + (result ? "YES" : "NO"));
        }
    }
}