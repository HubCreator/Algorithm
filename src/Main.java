import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch;
    static int count = 0;
    static int V, E;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        V = Integer.parseInt(st1.nextToken()); // 노드 (Vertex)
        E = Integer.parseInt(st1.nextToken());  // 간선 (Edge)
        graph = new ArrayList<>();
        ch = new int[V+1];
        StringTokenizer[] stArr = new StringTokenizer[E];

        for(int i = 0; i < E; i++)
            stArr[i] = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i <= V; i++)
            graph.add(new ArrayList<Integer>());

        for(int i = 0; i < E; i++) {
            int a = Integer.parseInt(stArr[i].nextToken());
            int b = Integer.parseInt(stArr[i].nextToken());
            graph.get(a).add(b);
        }

        ch[1] = 1;
        DFS(1);
        System.out.println(count);
    }

    private static void DFS(int val) {
        if(val == V) {
            count++;
        } else {
            for (int nv : graph.get(val)) {
                if(ch[nv] == 0) {
                    ch[nv] = 1;
                    DFS(nv);
                    ch[nv] = 0;
                }
            }
        }
    }
}
