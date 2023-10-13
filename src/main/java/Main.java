import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int count = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();
        int N = Integer.parseInt(st1.nextToken());
        int M = Integer.parseInt(st1.nextToken());
        int R = Integer.parseInt(st1.nextToken());
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st2.nextToken());
            int v = Integer.parseInt(st2.nextToken());
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        boolean[] check = new boolean[N + 1];
        int[] result = new int[N + 1];
        check[R] = true;
        result[R] = count++;
        dfs(adjList, check, result, R, 1);
        for (int i = 1; i < result.length; i++) {
            answer.append(result[i]).append('\n');
        }
        System.out.print(answer.deleteCharAt(answer.length() - 1));
    }

    private static void dfs(List<List<Integer>> adjList, boolean[] check, int[] result, int currNode, int level) {
        if (level + 1 == check.length) {
            return;
        } else {
            List<Integer> nodes = adjList.get(currNode);
            Collections.sort(nodes);
            for (Integer node : nodes) {
                if (!check[node]) {
                    check[node] = true;
                    result[node] = count++;
                    dfs(adjList, check, result, node, level + 1);
                }
            }
        }
    }
}
