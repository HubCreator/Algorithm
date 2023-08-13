import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static List<List<Integer>> list = new ArrayList<>();
    private static boolean[] check;
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        check = new boolean[n + 1];
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer input = new StringTokenizer(br.readLine());
            list.get(Integer.parseInt(input.nextToken())).add(Integer.parseInt(input.nextToken()));
        }
        check[1] = true;
        T.dfs(1);
        System.out.println(answer);
    }

    private void dfs(int level) {
        if (level == n) {
            if (check[n]) {
                answer++;
            }
            System.out.println();
        } else {
            List<Integer> entry = list.get(level);
            for (Integer index : entry) {
                if (!check[index]) {
                    check[index] = true;
                    dfs(index);
                    check[index] = false;
                }
            }
        }
    }
}
/**
5 9
1 2
1 3
1 4
2 1
2 3
2 5
3 4
4 2
4 5
 */
