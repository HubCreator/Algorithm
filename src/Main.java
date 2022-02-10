import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int[][] graph;
    static int[] ch;
    static int count = 0;
    static int V, E;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        V = Integer.parseInt(st1.nextToken());
        E = Integer.parseInt(st1.nextToken());
        graph = new int[V+1][V+1];
        ch = new int[V+1];
        StringTokenizer[] stArr = new StringTokenizer[E];

        for(int i = 0; i < E; i++)
            stArr[i] = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < E; i++)
            graph[Integer.parseInt(stArr[i].nextToken())][Integer.parseInt(stArr[i].nextToken())] = 1;

        DFS(1);
        System.out.println(count);
    }

    private static void DFS(int val) {
        if(val == V) {
            count++;
        } else {
            for(int i = 1; i <= V; i++) {
                if(graph[val][i] == 1 && ch[i] == 0 && val != i) {
                    ch[val] = 1;
                    DFS(i);
                    ch[val] = 0;
                }
            }
        }
    }
}
