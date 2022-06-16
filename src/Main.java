import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 좌표 정렬
public  class Main {
    static class Coord implements Comparable<Coord> {
        public int x, y;
        Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(Coord o) {
            if(this.x == o.x) return this.y - o.y;
            else return this.x - o.x;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Coord> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            list.add(new Coord(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(list);
        list.forEach(o -> System.out.println(o.x + " " + o.y));
    }
}