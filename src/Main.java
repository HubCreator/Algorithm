import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer[] tmp = new StringTokenizer[N];
        int[][] board = new int[N][N];
        int answer = 0;
        Stack<Integer> bucket = new Stack<>();

        for(int i = 0; i < N; i++)
            tmp[i] = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                board[i][j] = Integer.parseInt(tmp[i].nextToken());

        int M = Integer.parseInt(br.readLine());
        int[] moves = new int[M];
        StringTokenizer tmp2 = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < M; i++)
            moves[i] = Integer.parseInt(tmp2.nextToken());

        for (int pos : moves) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][pos - 1] != 0) {
                    int target = board[i][pos - 1];
                    board[i][pos - 1] = 0;
                    if (!bucket.isEmpty() && target == bucket.peek()) {
                        bucket.pop();
                        answer += 2;
                    } else bucket.push(target);
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}