import java.util.*;

class Solution {
    List<List<Integer>> list = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();
    int max = Integer.MIN_VALUE;

    private void bfs(int val) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[val + 1];
        visited[1] = true;
        for (int i = 0; i < list.get(1).size(); i++) { // 1과 연결된 노드들 모두 queue에 집어 넣음
            Integer t = list.get(1).get(i);
            visited[t] = true;
            map.put(t, 1);
            queue.offer(t);
        }

        while (!queue.isEmpty()) {
            Integer p = queue.poll();
            if (!visited[p]) { // 인접 노드를 찾아야 함
                List<Integer> tmpList = list.get(p);
                int tmpMin = Integer.MAX_VALUE;
                for (Integer x : tmpList) {
                    if (map.containsKey(x)) {
                        tmpMin = Math.min(tmpMin, map.get(x));
                    }
                }
                map.put(p, tmpMin + 1);
                max = Math.max(max, tmpMin + 1);
                visited[p] = true;
            } else {
                for (int j = 0; j < list.get(p).size(); j++) {
                    Integer t = list.get(p).get(j);
                    if (!visited[t] && !queue.contains(t)) queue.offer(t);
                }
            }
        }
    }

    public int solution(int n, int[][] edge) {
        int answer = 0, asdf = Integer.MIN_VALUE;

        for (int i = 0; i <= n; i++) list.add(new ArrayList<>());
        for (int[] e : edge) {
            list.get(e[0]).add(e[1]);
            list.get(e[1]).add(e[0]);
        }

        bfs(n);



        for (Integer x : map.values()) {
            asdf = Math.max(asdf, x);
        }

        for (Integer x : map.values()) {
            if(x == asdf) answer++;
        }


        return answer;
    }

    public static void main(String[] args) {
        Solution T = new Solution();
        int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        System.out.println(T.solution(6, edge));
    }
}