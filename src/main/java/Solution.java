import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    static StringBuilder answer = new StringBuilder();
    static StringTokenizer st;
    static int T, N, K;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine().trim());
        for (int test_case = 1; test_case <= T; test_case++) {

            initialize(br);
            answer.append("#" + test_case + " " + solution() + "\n");
        }
        System.out.println(answer);
    }

    private static void initialize(BufferedReader br) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }


    private static int solution() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            int rtRow, ltRow = 0;
            int rtCol, ltCol = 0;
            for (rtRow = 0, rtCol = 0; rtRow < N && rtCol < N; rtRow++, rtCol++) {
                if (board[i][rtRow] == 0) {
                    if (rtRow - ltRow == K) cnt++;
                    ltRow = rtRow + 1;
                }

                if (board[rtCol][i] == 0) {
                    if (rtCol - ltCol == K) cnt++;
                    ltCol = rtCol + 1;
                }
            }
            if (rtRow - ltRow == K) cnt++;
            if (rtCol - ltCol == K) cnt++;
        }
        return cnt;
    }
}