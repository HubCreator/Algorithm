import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {

    public static final String DELIMITER = " ";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            validate(stack,br);
        }
    }

    private static void validate(ArrayDeque<Integer> stack, BufferedReader br) throws IOException {
        String input = br.readLine();
        if (input.startsWith("push")) {
            stack.offer(Integer.parseInt(input.split(DELIMITER)[1]));
        }
        if (input.startsWith("pop")) {
            if (stack.isEmpty()) {
                System.out.println(-1);
                return;
            }
            System.out.println(stack.pollLast());
        }
        if (input.startsWith("size")) {
            System.out.println(stack.size());
        }
        if (input.startsWith("empty")) {
            System.out.println(stack.isEmpty() ? 1 : 0);
        }
        if (input.startsWith("top")) {
            if (stack.isEmpty()) {
                System.out.println(-1);
                return;
            }
            System.out.println(stack.peekLast());
        }
    }
}