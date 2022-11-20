import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    static StringBuilder answer = new StringBuilder();
    static int N;
    static char[][] board;
    static List<int[]> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            initialize(br);
            answer.append("#" + test_case + " " + solution() + "\n");
        }
        System.out.println(answer);
    }

    private static String solution() {
        if (list.size() == 0) return "yes";

        int[] leftTop = list.get(0);
        int[] rightBottom = list.get(list.size() - 1);

        if (rightBottom[0] - leftTop[0] != rightBottom[1] - leftTop[1] ||
                (int) Math.pow(rightBottom[1] - leftTop[1] + 1, 2) != list.size()) return "no";
        for (int i = leftTop[0]; i <= rightBottom[0]; i++) {
            for (int j = leftTop[1]; j <= rightBottom[1]; j++) {
                if (board[i][j] != '#') return "no";
            }
        }
        return "yes";
    }

    private static void initialize(BufferedReader br) throws IOException {
        N = Integer.parseInt(br.readLine());
        board = new char[N][N];
        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                if (str.charAt(j) == '#') list.add(new int[]{i, j});
                board[i][j] = str.charAt(j);
            }
        }
    }
}
