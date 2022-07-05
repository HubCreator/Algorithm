import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    private int solution(int n, int[][] board, int m, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < m; i++) {
            int tCol = moves[i];
            for (int j = 1; j <= n; j++) {
                if (board[j][tCol] != 0) {
                    if (!stack.isEmpty() && stack.peek() == board[j][tCol]) {
                        stack.pop();
                        answer += 2;
                    }
                    else stack.push(board[j][tCol]);
                    board[j][tCol] = 0;
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // board size
        int[][] board = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) board[i][j] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        int[] moves = new int[m];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) moves[i] = Integer.parseInt(st.nextToken());
        System.out.println(T.solution(n, board, m, moves));
    }
}