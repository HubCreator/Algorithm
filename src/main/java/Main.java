import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static int cache[][] = new int[100][100];

    // 0 : 못간다
    // 1 : 간다
    private static int jump(int[][] board, int y, int x) {
        if (y >= board.length || x >= board.length) return 0; // 기저 사례 : 게임판 밖을 벗어난 경우
        if (y == board.length - 1 && x == board.length - 1) return 1; // 기저 사례 : 목표 지점까지 도착한 경우

        if (cache[y][x] != -1) return cache[y][x]; // 메모이제이션

        int jumpSize = board[y][x];
        return cache[y][x] = jump(board, y, x + jumpSize) + jump(board, y + jumpSize, x);
    }

    private static List<String> solution(List<int[][]> list) {
        List<String> answer = new ArrayList<>();
        for (int[][] board : list) {
            initCache();
            if (jump(board, 0, 0) == 1) answer.add("YES");
            else answer.add("NO");
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        List<int[][]> list = new ArrayList<>();
        for (int i = 0; i < cnt; i++) {
            int boardLength = Integer.parseInt(br.readLine());
            int[][] board = new int[boardLength][boardLength];
            for (int j = 0; j < boardLength; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k < boardLength; k++) {
                    board[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            list.add(board);
        }


        for (String s : solution(list)) {
            System.out.println(s);
        }
    }

    private static void initCache() {
        // cache 초기화
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                cache[i][j] = -1;
            }
        }
    }
}