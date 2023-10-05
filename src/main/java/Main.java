import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        char[][] board = getBoard(br, row, col);
        int[][] countBoard = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (countBoard[i][j] == 0) {
                    count++;
                    move(countBoard, board, i, j);
                }
            }
        }
        System.out.print(count);
    }

    private static void move(int[][] countBoard, char[][] board, int i, int j) {
        int row = i, col = j;
        do {
            switch (board[row][col]) {
                case 'U': row--; break;
                case 'D': row++; break;
                case 'L': col--; break;
                case 'R': col++; break;
            }
            countBoard[row][col] = count;
        } while(row != i || col != j);
    }

    private static char[][] getBoard(BufferedReader br, int row, int col) throws IOException {
        char[][] board = new char[row][col];
        for (int i = 0; i < row; i++) {
            String line = br.readLine();
            for (int j = 0; j < col; j++) {
                board[i][j] = line.charAt(j);
            }
        }
        return board;
    }
}
