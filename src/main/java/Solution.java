import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
    static StringBuilder answer = new StringBuilder();
    static StringTokenizer st;
    static int N, result;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int test_case = 1; test_case <= 10; test_case++) {
            initialize(br);
            answer.append("#" + test_case + " " + solution() + "\n");
        }
        System.out.println(answer);
    }

    private static int solution() {
        Stack<Integer> stack = new Stack<>();
        result = 0;

        drop();

        for (int col = 0; col < N; col++) {
            for (int row = 0; row < N; row++) {
                if (board[row][col] == 0) continue;
                if (stack.isEmpty() || stack.peek() == board[row][col]) {
                    stack.push(board[row][col]);
                } else if (stack.peek() != board[row][col]) {
                    result++;
                    int idx = row + 1;
                    while (idx < N && board[idx][col] == board[row][col]) {
                        board[idx][col] = 0;
                        idx++;
                    }
                    stack.clear();
                }
            }
        }
        return result;
    }

    private static void drop() {
        for (int col = 0; col < N; col++) {
            for (int row = N - 1; row >= 0; row--) {
                if (board[row][col] == 1) { // 열방향으로 체크
                    int tmp = row + 1;
                    while (tmp < N && board[tmp][col] == 0) tmp++;
                    if (tmp == N) board[row][col] = 0;
                }
            }
        }

        for (int col = 0; col < N; col++) {
            for (int row = 0; row < N; row++) {
                if (board[row][col] == 2) {
                    int tmp = row - 1;
                    while (tmp >= 0 && board[tmp][col] == 0) tmp--;
                    if (tmp == -1) board[row][col] = 0;
                }
            }
        }
    }

    private static void initialize(BufferedReader br) throws IOException {
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

}