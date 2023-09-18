import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static final int START = 0;
    private static final int END = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            board[i][0] = Integer.parseInt(st.nextToken());
            board[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(board, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return Integer.compare(o1[START], o2[START]);
            }
            return Integer.compare(o1[END], o2[END]);
        });
        int start, end = Integer.MIN_VALUE;
        for (int[] ints : board) {
            if (ints[START] >= end) {
                start = ints[START];
                end = ints[END];
                answer++;
            }
        }
        System.out.println(answer);
    }
}
