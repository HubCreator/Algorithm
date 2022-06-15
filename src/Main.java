import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 크레인 인형뽑기
public class Main {
    private int solution(int[][] board, int[] moves) {
        Stack<Integer> bucket = new Stack<>();
        int answer = 0;

        for (int pos : moves) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][pos - 1] != 0) { // 0이 아닐때지 내려옴
                    int target = board[i][pos - 1];
                    board[i][pos - 1] = 0; // board의 해당 위치의 값을 0으로 바꿈
                    if (!bucket.isEmpty() && target == bucket.peek()) {
                        bucket.pop();
                        answer += 2;
                    }
                    else
                        bucket.push(target);
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main t = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer[] stArr = new StringTokenizer[n];
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            stArr[i] = new StringTokenizer(br.readLine(), " ");
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(stArr[i].nextToken());
            }
        }
        int moveCnt = Integer.parseInt(br.readLine());
        int[] moves = new int[moveCnt];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < moves.length; i++) {
            moves[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(t.solution(board, moves));
    }
}