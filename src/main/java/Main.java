import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    private static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st1.nextToken());
            int M = Integer.parseInt(st1.nextToken());
            Deque<Document> queue = new ArrayDeque<>();
            for (int j = 0; j < N; j++) {
                queue.offer(new Document(j, Integer.parseInt(st2.nextToken())));
            }
            solution(M, queue);
        }
        System.out.print(answer);
    }

    private static void solution(int m, Deque<Document> queue) {
        int result = 0;
        boolean flag;
        while (!queue.isEmpty()) {
            flag = false;
            Document poll = queue.poll();
            for (Document document : queue) {
                if (poll.value < document.value) {
                    queue.offerLast(poll);
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                result++;
                if (poll.index == m) {
                    answer.append(result).append('\n');
                    return;
                }
            }
        }
    }

    private static class Document {
        int index, value;

        public Document(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
