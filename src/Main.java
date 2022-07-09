import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>{
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

    private int find(int v) {
        if(unf[v] == v) return unf[v];
        else return unf[v] = find(unf[v]);
    }

    private void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if(fa != fb) unf[fa] = fb;
    }

    private int solution(ArrayList<Edge> list) {
        int answer = 0;
        Collections.sort(list);
        for (Edge e : list) {
            if (find(e.from) != find(e.to)) {
                union(e.from, e.to);
                answer += e.cost;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        ArrayList<Edge> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        unf = new int[v + 1];
        for (int i = 1; i <= v; i++) unf[i] = i;
        for (int i = 0; i < e; i++) {
            StringTokenizer tmp = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(tmp.nextToken());
            int to = Integer.parseInt(tmp.nextToken());
            int cost = Integer.parseInt(tmp.nextToken());
            list.add(new Edge(from, to, cost));
        }
        System.out.println(T.solution(list));
    }
}