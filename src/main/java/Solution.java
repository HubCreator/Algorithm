import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
    static final int BOARD_SIZE = 9;
    static StringBuilder answer = new StringBuilder();
    static StringTokenizer st;
    static int T;
    static int[][] board;
    static Set<Integer> setRow, setCol, set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            initialize(br);
            answer.append("#" + test_case + " " + mainLogic() + "\n");
        }
        System.out.println(answer);
    }

    private static int mainLogic() {
        // 행과 열 판단
        for (int i = 0; i < BOARD_SIZE; i++) {
            setRow = new HashSet<>();
            setCol = new HashSet<>();
            for (int j = 0; j < BOARD_SIZE; j++) {
                setRow.add(board[i][j]);
                setCol.add(board[j][i]);
            }
            if (setRow.size() != BOARD_SIZE || setCol.size() != BOARD_SIZE) return 0;
        }
        // 3X3 영역 판단
        for (int i = 0; i <= BOARD_SIZE - 3; i += 3) {
            for (int j = 0; j <= BOARD_SIZE - 3; j += 3) {
                set = new HashSet<>();
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        set.add(board[k][l]);
                    }
                }
                if (set.size() != BOARD_SIZE) return 0;
            }
        }

        return 1;
    }

    private static void initialize(BufferedReader br) throws IOException {
        board = new int[BOARD_SIZE][BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}