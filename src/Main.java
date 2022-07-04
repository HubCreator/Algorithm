import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Edge implements Comparable<Edge> {
    int v, cost;

    public Edge(int v, int cost) {
        this.v = v;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}

public class Main {
    static int[] dis;
    static List<List<Edge>> list = new ArrayList<>();

    private void solution(int v) {
        PriorityQueue<Edge> pQueue = new PriorityQueue<>();
        pQueue.offer(new Edge(v, 0));
        dis[v] = 0;
        while (!pQueue.isEmpty()) {
            Edge p = pQueue.poll();
            int curV = p.v;
            int curCost = p.cost;
            if(dis[curV] < curCost) continue; // 기존에 구해놓은 것보다 크다면 아래의 로직을 돌 필요가 없음
            for (Edge e : list.get(curV)) {
                if (dis[e.v] > curCost + e.cost) {
                    dis[e.v] = curCost + e.cost;
                    pQueue.offer(new Edge(e.v, curCost + e.cost));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tmp = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(tmp.nextToken());
        int m = Integer.parseInt(tmp.nextToken());
        for (int i = 0; i <= n; i++) list.add(new ArrayList<>()); // list 내의 list 초기화
        dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE); // 최댓값으로 초기화함
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list.get(from).add(new Edge(to, w));
        }
        T.solution(1); // 1번 정점에서 출발해라
        for (int i = 2; i <= n; i++) {
            if(dis[i] != Integer.MAX_VALUE) System.out.println(i + " : " + dis[i]);
            else System.out.println("impossible");
        }
    }
}