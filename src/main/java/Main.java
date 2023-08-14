import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());
        int[] scores = new int[n];
        int[] times = new int[n];
        boolean[] check = new boolean[n];
        int scoreSum = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            scores[i] = Integer.parseInt(st.nextToken());
            times[i] = Integer.parseInt(st.nextToken());
        }

        T.dfs(scores, times, 0, 0, m, 0);
        System.out.println(answer);
    }

    private void dfs(int[] scores, int[] times, int scoreSum, int timeSum, int m, int level) {
        if (level == scores.length) {
            if (timeSum <= m) {
                answer = Math.max(answer, scoreSum);
            }
        } else {
            dfs(scores, times, scoreSum += scores[level], timeSum += times[level], m, level + 1);
            dfs(scores, times, scoreSum -= scores[level], timeSum -= times[level], m, level + 1);
        }
    }
}
