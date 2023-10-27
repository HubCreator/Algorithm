import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static char[][] board;
    private static String inkLine;
    private static int[] boxCoord;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int I = Integer.parseInt(st1.nextToken());
        int N = Integer.parseInt(st1.nextToken());
        int K = Integer.parseInt(st1.nextToken());
        board = new char[N][N];
        inkLine = br.readLine();
        boxCoord = initBoard(br, N);
        String commandLine = br.readLine();
        solution(commandLine);

        StringBuilder answer = new StringBuilder();
        for (char[] chars : board) {
            for (char aChar : chars) {
                answer.append(aChar);
            }
            answer.append('\n');
        }
        System.out.print(answer.deleteCharAt(answer.length() - 1));
    }

    private static void solution(String commandLine) {
        int inkCount = 0, inkIndex = 0;
        for (int i = 0; i < commandLine.length(); i++) {
            char command = commandLine.charAt(i);
            switch (command) {
                case 'j':
                    inkCount++;
                    break;
                case 'J':
                    char color = inkLine.charAt(inkIndex);
                    coloring(color, inkCount);
                    inkCount = 0;
                    inkIndex = (inkIndex + 1) % inkLine.length();
                    break;
                default:
                    int y = boxCoord[0], x = boxCoord[1];
                    if (command == 'U' && boxCoord[0] - 1 >= 0 && board[boxCoord[0] - 1][boxCoord[1]] != '#') {
                        boxCoord = new int[]{y - 1, x};
                    }
                    if (command == 'D' && boxCoord[0] + 1 < board.length && board[boxCoord[0] + 1][boxCoord[1]] != '#') {
                        boxCoord = new int[]{y + 1, x};
                    }
                    if (command == 'L' && boxCoord[1] - 1 >= 0 && board[boxCoord[0]][boxCoord[1] - 1] != '#') {
                        boxCoord = new int[]{y, x - 1};
                    }
                    if (command == 'R' && boxCoord[1] + 1 < board.length && board[boxCoord[0]][boxCoord[1] + 1] != '#') {
                        boxCoord = new int[]{y, x + 1};
                    }
                    break;
            }
        }
        board[boxCoord[0]][boxCoord[1]] = '@';
    }

    private static void coloring(char color, int inkCount) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (Math.abs(boxCoord[0] - i) + Math.abs(boxCoord[1] - j) <= inkCount &&
                        board[i][j] != '.') {
                    board[i][j] = color;
                }
            }
        }
    }

    private static int[] initBoard(BufferedReader br, int N) throws IOException {
        int[] boxCoord = null;
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                char c = line.charAt(j);
                if (c == '@') {
                    boxCoord = new int[]{i, j};
                    board[i][j] = '.';
                    continue;
                }
                board[i][j] = c;
            }
        }
        return boxCoord;
    }
}
