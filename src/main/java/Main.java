import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();
        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());
        int k = Integer.parseInt(st1.nextToken());
        char[][] board = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                board[i][j] = line.charAt(j);
            }
        }

        int min = Integer.MAX_VALUE;
        char[][] minBoard = new char[n][m];
        for (int i = 0; i < board.length - k; i += k) {
            for (int j = 0; j < board[i].length - k; j += k) {
                char[][] mask = makeMask(board, i, j, k);
                int count = 0;
                char[][] copiedBoard = copyBoard(board);
                for (int y = 0; y < board.length; y += k) {
                    for (int x = 0; x < board[y].length; x += k) {
                        count += solution(mask, k, copiedBoard, y, x);
                    }
                }
                if (min > count) {
                    min = count;
                    minBoard = copiedBoard;
                }
            }
        }
        answer.append(min).append('\n');
        for (int i = 0; i < minBoard.length; i++) {
            for (int j = 0; j < minBoard[i].length; j++) {
                answer.append(minBoard[i][j]);
            }
            answer.append('\n');
        }

        System.out.println(answer);
    }

    private static char[][] copyBoard(char[][] board) {
        char[][] copy = new char[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                copy[i][j] = board[i][j];
            }
        }
        return copy;
    }

    private static int solution(char[][] mask, int k, char[][] board, int y, int x) {
        int count = 0;
        for (int i = y; i < y + k; i++) {
            for (int j = x; j < x + k; j++) {
                if (board[i][j] != mask[i % k][j % k]) {
                    board[i][j] = mask[i % k][j % k];
                    count++;
                }
            }
        }
        return count;
    }

    private static char[][] makeMask(char[][] board, int i, int j, int k) {
        char[][] mask = new char[k][k];
        for (int y = i; y < i + k; y++) {
            for (int x = j; x < j + k; x++) {
                mask[y % k][x % k] = board[y][x];
            }
        }
        return mask;
    }
}
