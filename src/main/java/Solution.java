import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int[] answer;
    public int level = 0;

    public int solution(int n, int[][] edge) {
        answer = new int[n + 1];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] path : edge) {
            graph.get(path[0]).add(path[1]);
            graph.get(path[1]).add(path[0]);
        }
        boolean[] check = new boolean[n + 1];
        bfs(n, graph, check);
        return answer[level - 1];
    }

    public void bfs(int n, List<List<Integer>> graph, boolean[] check) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        check[1] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            answer[level] = size;
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                List<Integer> nexts = graph.get(poll);
                for (Integer nx : nexts) {
                    if (!check[nx]) {
                        check[nx] = true;
                        queue.offer(nx);
                    }
                }
            }
            level++;
        }
    }
}
