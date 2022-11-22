import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class Solution {
    static final int SIZE = 8;

    static StringBuilder answer = new StringBuilder();
    static StringTokenizer st;
    static Deque<Integer> deque;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 1; i <= 10; i++) {
            int n = Integer.parseInt(br.readLine());
            initialize(br);
            answer.append("#" + n + " " + solution() + "\n");
        }
        System.out.println(answer);
    }

    private static String solution() {
        StringJoiner stringJoiner = new StringJoiner(" ", "", "");

        while (!deque.isEmpty() && deque.peekFirst() > 0) {
            for (int i = 1; i <= 5; i++) {
                if (deque.peekFirst() - i <= 0) {
                    deque.pollFirst();
                    deque.offerFirst(0);
                    break;
                }
                deque.offerLast(deque.pollFirst() - i);
            }
        }
        deque.pollFirst();
        deque.offerLast(0);

        for (Integer x : deque) stringJoiner.add(x + "");
        return stringJoiner.toString();
    }

    private static void initialize(BufferedReader br) throws IOException {
        deque = new ArrayDeque<>(SIZE);
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < SIZE; j++) {
            deque.offerLast(Integer.parseInt(st.nextToken()));
        }
    }
}