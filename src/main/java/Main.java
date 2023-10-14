import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int t = Integer.parseInt(br.readLine());
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        boolean[] check = new boolean[n + 1];
        check[1] = true;
        dfs(adjList, 1, check);

        System.out.print(count);
    }

    private static void dfs(List<List<Integer>> adjList, int curr, boolean[] check) {
        List<Integer> nodes = adjList.get(curr);
        for (Integer node : nodes) {
            if (!check[node]) {
                check[node] = true;
                count++;
                dfs(adjList, node, check);
            }
        }
    }
}
