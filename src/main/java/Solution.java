import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static final int BOARD_SIZE = 8;
    static StringBuilder answer = new StringBuilder();
    static int N;
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int test_case = 1; test_case <= 10; test_case++) {
            initialize(br);
            answer.append("#" + test_case + " " + solution() + "\n");
        }
        System.out.println(answer);
    }

    private static void initialize(BufferedReader br) throws IOException {
        board = new char[BOARD_SIZE][BOARD_SIZE];
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < BOARD_SIZE; i++) {
            String str = br.readLine();
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = str.charAt(j);
            }
        }
    }

    private static int solution() {
        int result = 0;
        for (int i = 0; i < BOARD_SIZE; i++) {
            // 초기 윈도우 생성
            StringBuilder sbRow = new StringBuilder();
            StringBuilder sbCol = new StringBuilder();
            for (int j = 0; j < N - 1; j++) {
                sbRow.append(board[i][j]);
                sbCol.append(board[j][i]);
            }
            // 슬라이딩 윈도우
            for (int j = N - 1; j < BOARD_SIZE; j++) {
                sbRow.append(board[i][j]);
                if (isPalindrome(sbRow.toString())) result++;
                sbRow.deleteCharAt(0);

                sbCol.append(board[j][i]);
                if (isPalindrome(sbCol.toString())) result++;
                sbCol.deleteCharAt(0);
            }
        }
        return result;
    }

    private static boolean isPalindrome(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}