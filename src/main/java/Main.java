import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final List<List<Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer t = new StringTokenizer(br.readLine());
            list.get(Integer.parseInt(t.nextToken())).add(Integer.parseInt(t.nextToken()));
        }
        for (int i = 2; i <= n; i++) {
            System.out.println(i + " : " + T.bfs(i));
        }
    }

    private int bfs(int target) {
        Queue<Integer> queue = new ArrayDeque<>(list.get(1));
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                if (poll == target) {
                    return level;
                }
                List<Integer> nexts = list.get(poll);
                for (Integer next : nexts) {
                    if (!queue.contains(next)) {
                        queue.offer(next);
                    }
                }
            }
            level++;
        }
        return -1;
    }
}
/*
6 9
1 3
1 4
2 1
2 5
3 4
4 5
4 6
6 2
6 5
 */
