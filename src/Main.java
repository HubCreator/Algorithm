import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
    int from, to, cost;

    public Edge(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}

public class Main {
    static int[] unf;
    static int answer = 0;

    int Find(int v) {
        if (unf[v] == v) return unf[v];
        else return unf[v] = Find(unf[v]);
    }

    void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if (fa != fb) unf[fa] = fb;
    }

    private void solution(int v, int e, List<Edge> list) {
        Collections.sort(list); // cost를 기준으로 오름차순 정렬
        for (int i = 0; i < list.size(); i++) {
            Edge t = list.get(i);
            if (Find(t.from) != Find(t.to)) {
                Union(t.from, t.to);
                answer += t.cost;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        List<Edge> list = new ArrayList<>();
        unf = new int[v + 1];
        for (int i = 1; i <= v; i++) unf[i] = i; // 초기화
        for (int i = 0; i < e; i++) {
            StringTokenizer tmp = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(tmp.nextToken());
            int to = Integer.parseInt(tmp.nextToken());
            int cost = Integer.parseInt(tmp.nextToken());
            list.add(new Edge(from, to, cost));
        }
        T.solution(v, e, list);
        System.out.println(answer);
    }
}