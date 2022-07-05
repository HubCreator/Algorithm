import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    private int solution(int n, int k) {
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= n; i++) deque.addLast(i);
        while (deque.size() != 1) {
            for (int i = 0; i < k - 1; i++) {
                Integer x = deque.removeFirst();
                deque.addLast(x);
            }
            deque.removeFirst();
        }
        return deque.getFirst();
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        System.out.println(T.solution(n, k));;
    }
}