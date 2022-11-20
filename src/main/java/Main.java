import java.io.*;
import java.util.*;

class Main {
    static final int SIZE = 5;
    static char board[][] = new char[SIZE][SIZE];
    static Map<Character, int[]> map;
    static List<String> tokens;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String message = br.readLine();
        String key = br.readLine();
        makeBoard(key);
        transformMessage(message);
        System.out.println(encode());
    }

    private static String encode() {
        StringBuilder result = new StringBuilder();

        for (String token : tokens) {
            int[] firstCoord = map.get(token.charAt(0));
            int[] lastCoord = map.get(token.charAt(1));
            if (firstCoord[0] == lastCoord[0]) { // 같은 행
                result.append(board[firstCoord[0]][(firstCoord[1] + 1) % SIZE]);
                result.append(board[lastCoord[0]][(lastCoord[1] + 1) % SIZE]);
            } else if (firstCoord[1] == lastCoord[1]) { // 같은 열
                result.append(board[(firstCoord[0] + 1) % SIZE][firstCoord[1]]);
                result.append(board[(lastCoord[0] + 1) % SIZE][lastCoord[1]]);
            } else {
                result.append(board[firstCoord[0]][lastCoord[1]]);
                result.append(board[lastCoord[0]][firstCoord[1]]);
            }
        }
        return result.toString();
    }

    private static void transformMessage(String message) {
        int idx = 0;
        tokens = new ArrayList<>();
        StringBuilder buffer = new StringBuilder();
        while (idx < message.length()) {
            if (buffer.length() == 2) {
                if (buffer.charAt(0) == buffer.charAt(1)) {
                    char ch = buffer.charAt(0) == 'X' ? 'Q' : 'X';
                    tokens.add(String.valueOf(buffer.charAt(0)) + ch);
                    buffer.deleteCharAt(0);
                } else {
                    tokens.add(buffer.toString());
                    buffer = new StringBuilder();
                }
                continue;
            } else {
                buffer.append(message.charAt(idx));
            }
            idx++;
        }
        if (buffer.length() == 2) {
            tokens.add(buffer.toString());
        }
        else if (buffer.length() == 1) {
            tokens.add(buffer.toString() + 'X');
        }
    }

    private static void makeBoard(String key) {
        StringBuilder sb = new StringBuilder(key);
        for (char i = 'A'; i <= 'Z'; i++) sb.append(i);

        map = new HashMap<>();
        char[] chars = sb.toString().toCharArray();
        int idx = 0;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                while (map.containsKey(chars[idx]) || chars[idx] == 'J') idx++;
                map.put(chars[idx], new int[]{i, j});
                board[i][j] = chars[idx];
                idx++;
            }
        }
    }
}