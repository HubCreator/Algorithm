import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 1;
        int n = Integer.parseInt(br.readLine());
        double[] room = new double[n + 1];
        Set<int[]> behavior = new LinkedHashSet<>();
        int m = Integer.parseInt(br.readLine());
        if (m == 0) {
            System.out.println(n);
            return;
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            behavior.add(new int[]{x, y});
        }
        crushRoom(room, behavior);

        double target = room[1];
        for (int i = 2; i <= n; i++) {
            if (target != room[i] || room[i] == 0.0) {
                answer++;
                target = room[i];
            }
        }
        System.out.println(answer);
    }

    private static void crushRoom(double[] room, Set<int[]> behavior) {
        for (int[] ints : behavior) {
            int x = ints[0], y = ints[1];
            double random = room[x] == 0.0 ?
                    Math.random() :
                    room[x];
            for (int i = x; i <= y; i++) {
                room[i] = random;
            }
        }
    }
}
