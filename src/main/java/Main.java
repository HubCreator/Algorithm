import java.io.*;
import java.util.*;

class Main {
    static StringTokenizer st;
    static StringBuilder answer = new StringBuilder();
    static List<Integer> result = new ArrayList<>();
    static int[][] arr;
    static int T;
    static final int[] dy = {0, 0, -1, 1};
    static final int[] dx = {1, -1, 0, 0};

    private static void initialize(BufferedReader br) throws IOException {
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < T; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void mainLogic() {
        for (int i = 0; i < T; i++) {
            for (int j = 0; j < T; j++) {
                if (arr[i][j] == 1) bfs(i, j);
            }
        }
    }

    private static void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        int cnt = 0;
        queue.offer(new int[]{i, j});
        arr[i][j] = 0;
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            cnt++;
            for (int dir = 0; dir < 4; dir++) {
                int ny = p[0] + dy[dir];
                int nx = p[1] + dx[dir];
                if (ny >= 0 && ny < T && nx >= 0 && nx < T && arr[ny][nx] == 1) {
                    queue.offer(new int[]{ny, nx});
                    arr[ny][nx] = 0; // 여기서 체크를 해야만 함
                }
            }
        }
        result.add(cnt);
    }

    private static void printResult() {
        Collections.sort(result);
        answer.append(result.size() + "\n");
        for (Integer x : result) answer.append(x + " ");
        System.out.println(answer);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        arr = new int[T][T];
        initialize(br);
        mainLogic();
        printResult();
    }
}