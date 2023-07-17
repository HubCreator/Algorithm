import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        System.out.println(T.solution(n, k));
    }

    private int solution(int n, int k) {
        int count = 1;
        Deque<Prince> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            queue.offerLast(new Prince(i));
        }
        while (queue.size() != 1) {
            Prince poll = queue.pollFirst();
            if (count % k != 0) {
                queue.addLast(poll);
            }
            count++;
        }
        return queue.poll().val;
    }

    static class Prince {
        final int val;

        public Prince(int val) {
            this.val = val;
        }
    }
}
