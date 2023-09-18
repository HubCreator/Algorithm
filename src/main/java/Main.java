import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());
        List<List<Edge>> map = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            map.add(new ArrayList<>());
        }
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            int c = Integer.parseInt(st2.nextToken());
            min = Math.min(min, c);
            max = Math.max(max, c);
            map.get(a).add(new Edge(b, c));
            map.get(b).add(new Edge(a, c));
        }
        StringTokenizer st3 = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st3.nextToken());
        int to = Integer.parseInt(st3.nextToken());
        int answer = 0;

        // weight를 기준으로 최적해를 찾아나감 (뭐 하나만 보고 이게 답이다 할 수가 없는 상황)
        while (min <= max) {
            int mid = (min + max) / 2;
            if (bfs(map, mid, from, to)) {
                min = mid + 1; // 중량을 더 높여도 된다
                answer = mid;
            } else {
                max = mid - 1;
            }
        }

        System.out.println(answer);
    }

    private static boolean bfs(List<List<Edge>> board, int mid, int from, int to) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(from);
        boolean[] visited = new boolean[board.size() + 1];
        visited[from] = true;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            if (poll == to) {
                return true;
            }
            for (int i = 0; i < board.get(poll).size(); i++) {
                int targetVertex = board.get(poll).get(i).vertex;
                if (board.get(poll).get(i).weight >= mid && !visited[targetVertex]) {
                    visited[targetVertex] = true;
                    queue.offer(targetVertex);
                }
            }
        }
        return false;
    }

    private static class Edge {
        private final int vertex, weight;

        public Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }
}
