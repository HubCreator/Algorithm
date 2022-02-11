import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N, M;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] dist, ch;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st1.nextToken()); // 정점의 수
        M = Integer.parseInt(st1.nextToken()); // 간선의 수
        dist = new int[N + 1];
        ch = new int[N + 1];

        StringTokenizer[] st2 = new StringTokenizer[M];
        for (int i = 0; i < M; i++)
            st2[i] = new StringTokenizer(br.readLine(), " ");

        graph = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i <= N; i++)
            graph.add(new ArrayList<Integer>());

        for (int i = 0; i < M; i++) {
            int a = Integer.parseInt(st2[i].nextToken());
            int b = Integer.parseInt(st2[i].nextToken());
            graph.get(a).add(b);
        }

        BFS(1);
        for(int i = 2; i < N; i++)
            System.out.println(i + " : " + dist[i]);
    }

    private static void BFS(int v) {
        Queue<Integer> queue = new LinkedList<>();
        ch[v] = 1;
        dist[v] = 0;
        queue.offer(v);
        while (!queue.isEmpty()) {
            int cv = queue.poll(); // current vertext
            for(int nv : graph.get(cv)) {
                if(ch[nv] == 0) {
                    ch[nv] = 1;
                    queue.offer(nv);
                    dist[nv] = dist[cv]+1;
                }
            }
        }
    }
}