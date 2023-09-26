import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
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

        int count = 0;
        char[][] mask = new char[k][k];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                Map<Character, Integer> map = new HashMap<>();
                for (int y = i; y < n; y += k) {
                    for (int x = j; x < m; x += k) {
                        map.put(board[y][x], map.getOrDefault(board[y][x], 0) + 1);
                    }
                }
                char result = ' ';
                int max = Integer.MIN_VALUE;
                for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                    if (max < entry.getValue()) {
                        max = entry.getValue();
                        result = entry.getKey();
                    }
                }
                mask[i][j] = result;
                count += (n / k) * (m / k) - max;
            }
        }
        char[][] resultBoard = new char[n][m];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                for (int y = i; y < n; y += k) {
                    for (int x = j; x < m; x += k) {
                        resultBoard[y][x] = mask[i][j];
                    }
                }
            }
        }
        answer.append(count).append('\n');
        for (char[] chars : resultBoard) {
            for (char c : chars) {
                answer.append(c);
            }
            answer.append('\n');
        }
        System.out.println(answer.deleteCharAt(answer.length() - 1));
    }
}
