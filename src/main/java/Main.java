import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st1.nextToken());
        int K = Integer.parseInt(st1.nextToken());
        int M = Integer.parseInt(st1.nextToken());
        List<List<Integer>> board = new ArrayList<>();
        for (int i = 0; i <= N + M; i++) {
            board.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++) {
                int t = Integer.parseInt(st2.nextToken());
                board.get(t).add(N + i + 1); // 공간 복잡도 줄이기
                board.get(N + i + 1).add(t);
            }
        }
        System.out.println(bfs(board, N, M));
    }

    private static int bfs(List<List<Integer>> board, int N, int M) {
        boolean[] visited = new boolean[N + M + 1];
        int[] distance = new int[N + M + 1];

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        visited[1] = true;
        distance[1] = 1;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            for (Integer next : board.get(poll)) {
                if (visited[next]) {
                    continue;
                }
                visited[next] = true;
                distance[next] = distance[poll] + 1;
                queue.offer(next);
            }
        }
        if (visited[N]) {
            return distance[N] / 2 + 1;
        }
        return -1;
    }
}
