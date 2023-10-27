import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            result = Integer.MAX_VALUE;
            int N = Integer.parseInt(br.readLine());
            List<List<Integer>> list = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                list.add(new ArrayList<>());
            }
            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int d = Integer.parseInt(st.nextToken());
                for (int k = 0; k < d; k++) {
                    int t = Integer.parseInt(st.nextToken()) - 1;
                    list.get(j).add(t);
                }
            }
            boolean[] check = new boolean[N];
            dfs(list, check, 0);
            answer.append(result).append('\n');
        }
        System.out.print(answer);
    }

    private static void dfs(List<List<Integer>> list, boolean[] check, int level) {
        if (level == check.length) {
            boolean[] history = new boolean[check.length];
            int count = 0;
            for (int i = 0; i < check.length; i++) {
                if (check[i]) {
                    history[i] = true;
                    for (Integer friend : list.get(i)) {
                        history[friend] = true;
                    }
                    count++;
                }
            }
            int sum = 0;
            for (boolean b : history) {
                if (b) {
                    sum += 1;
                }
            }
            if (sum == check.length) {
                result = Math.min(result, count);
            }
        } else {
            if (!check[level]) {
                check[level] = true;
                dfs(list, check, level + 1);
                check[level] = false;
                dfs(list, check, level + 1);
            }
        }
    }
}
