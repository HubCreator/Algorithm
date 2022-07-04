import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Point {
    int y, x;

    public Point(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {
    static int n, m, len, answer = Integer.MAX_VALUE;
    static int[] combi;
    static List<Point> pizzaHs = new ArrayList<>();
    static List<Point> hs = new ArrayList<>();

    private void DFS(int L, int s) {
        if (L == m) { // 조합을 만족하는 경우
            int sum = 0;
            for (Point hsPoint : hs) { // 집을 기준으로
                int dis = Integer.MAX_VALUE;
                for (int x : combi) { // 피자집에 대한 거리를 측정
                    Point pzPoint = pizzaHs.get(x);
                    dis = Math.min(dis, Math.abs(hsPoint.x - pzPoint.x) + Math.abs(hsPoint.y - pzPoint.y)); // 거리들 중 가장 작은 값만을 취급
                }
                sum += dis; // 다른 집들도 똑같이 최소 거리값만 뽑아 저장
            }
            answer = Math.min(answer, sum);
        } else {
            for (int i = s; i < len; i++) {
                combi[L] = i; // combi 배열에 인덱스 값을 저장
                DFS(L + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken()); // n x n
        m = Integer.parseInt(st.nextToken()); // m 개의 매장 폐업

        for (int y = 0; y < n; y++) {
            StringTokenizer tmp = new StringTokenizer(br.readLine(), " ");
            for (int x = 0; x < n; x++) {
                int el = Integer.parseInt(tmp.nextToken());
                if (el == 1) hs.add(new Point(y, x));
                else if (el == 2) pizzaHs.add(new Point(y, x));
            }
        }
        len = pizzaHs.size();
        combi = new int[m];
        T.DFS(0, 0);
        System.out.println(answer);
    }
}