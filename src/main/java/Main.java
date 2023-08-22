import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());

        System.out.println(T.bfs(arr, n, m));
    }

    private int bfs(int[] arr, int n, int m) {
        Queue<Integer> queue = new ArrayDeque<>();
        int level = 1;
        for (int i = 0; i < n; i++) {
            queue.offer(arr[i]);
        }

        while (!queue.isEmpty()) {
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                Integer poll = queue.poll();
                if (poll == m) {
                    return level;
                }
                for (int j = 0; j < n; j++) {
                    queue.offer(poll + arr[j]);
                }
            }
            level++;
        }
        return -1;
    }
}
