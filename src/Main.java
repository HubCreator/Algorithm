import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static int[] answer;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    private void BFS(int val) {
        int level = 0;
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> ch = new ArrayList<>();
        for (Integer x : graph.get(1)) queue.offer(x); // 1번 노드에서 갈 수 있는 노드들을 queue에 추가 (초기 설정)

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Integer p = queue.poll(); // 한놈 뽑아서
                if (p == val) {
                    answer[val] = level + 1; // 그게 val값이면 우리가 찾는 답이다
                    return;
                }
                ch.add(p); // 뽑은 놈을 ch에 넣어 중복 경로 제거
                for (Integer t : graph.get(p)) { // 뽑은 놈에서의 가지들을 체크
                    if (!ch.contains(t) && !queue.contains(t)) { // 이미 뽑았던 놈이거나 큐에 존재하는 것들은 중복 경로 이므로 제외
                        queue.offer(t);
                    }
                }
            }
            level++;
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        answer = new int[n + 1];
        for (int i = 0; i < m; i++) {
            StringTokenizer tmp = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(tmp.nextToken());
            int to = Integer.parseInt(tmp.nextToken());
            graph.get(from).add(to);
        }
        for (int i = 2; i <= n; i++) T.BFS(i);
        for (int i = 2; i <= n; i++) System.out.println(i + " : " + answer[i]);

    }
}