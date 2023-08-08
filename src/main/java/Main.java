import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 시간 복잡도 : O(n)
// 공간 복잡도 : O(n)
public class Main {
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        System.out.println(T.bfs(s, e));
    }

    private int bfs(int s, int e) {
        int[] dir = new int[]{-1, 1, 5};
        int result = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(s);
        while (!queue.isEmpty()) {
            int size = queue.size();
            result++;
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                for (int d : dir) {
                    if (poll == e) {
                        return result - 1;
                    }
                    queue.offer(poll + d);
                }
            }
        }
        return -1;
    }
}
