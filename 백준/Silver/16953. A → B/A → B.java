import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        int answer = 1;

        Queue<Long> queue = new LinkedList<>();
        queue.offer(a);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Long poll = queue.poll();
                if (poll == b) {
                    System.out.print(answer);
                    return;
                }
                if (poll * 2 <= b) {
                    queue.offer(poll * 2);
                }
                if (poll * 10 + 1 <= b) {
                    queue.offer(poll * 10 + 1);
                }
            }
            answer++;
        }

        System.out.print(-1);
    }
}
