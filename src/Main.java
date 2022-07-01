import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Brick implements Comparable<Brick> {
    int s, h, w;

    public Brick(int s, int h, int w) {
        this.s = s;
        this.h = h;
        this.w = w;
    }

    @Override
    public int compareTo(Brick o) {
        return o.s - this.s; // 밑면 기준으로 내림차순 정렬
    }
}

public class Main {
    static int[] dy;

    private void solution(int n, List<Brick> list) {
        Collections.sort(list);
        dy = new int[n]; // 각 인덱스의 brick이 최상위에 있을 때 탑의 최대 높이
        dy[0] = list.get(0).h; // 첫 번재 값 초기화

        for (int i = 1; i < n; i++) {
            int sum = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (list.get(j).w > list.get(i).w) {
                    sum = Math.max(sum, dy[j]);
                }
            }
            dy[i] = sum + list.get(i).h;
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Brick> list = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken()); // 밑면 넓이
            int h = Integer.parseInt(st.nextToken()); // 높이
            int w = Integer.parseInt(st.nextToken()); // 무게
            list.add(new Brick(s, h, w));
        }
        T.solution(n, list);
        System.out.println(Arrays.stream(dy).max().getAsInt());
    }
}