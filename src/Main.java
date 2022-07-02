import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private int solution(int n, int[][] board) {
        int answer = 0, max = 0;
        for (int i = 1; i <= n; i++) { // 기준 학생
            int cnt = 0;
            for (int j = 1; j <= n; j++) { // 비교 학생
                for (int k = 1; k <= 5; k++) { // 비교 학년
                    if (board[i][k] == board[j][k]) {
                        cnt++;
                        break;
                    }
                }
            }
            if (cnt > max) {
                max = cnt;
                answer = i;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n + 1][6];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= 5; j++) board[i][j] = Integer.parseInt(st.nextToken());
        }
        System.out.println(T.solution(n, board));
    }
}