import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    int[] dx = {1, 5, -1};
    int[] ch;

    private int BFS(int s, int e) {
        int answer = 0;
         ch = new int[10001];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s); // 초기값
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Integer p = queue.poll();
                for (int j = 0; j < 3; j++) {
                    int nx = p + dx[j];
                    if (nx == e) return answer + 1;
                    if (nx >= 1 && nx <= 10000 && ch[nx] == 0) {
                        queue.offer(nx);
                        ch[nx] = 1;
                    }
                }
            }
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        System.out.println(T.BFS(s, e));
    }
}