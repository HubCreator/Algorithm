import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            points.add(new Point(Integer.parseInt(st.nextToken()), true));
            points.add(new Point(Integer.parseInt(st.nextToken()), false));
        }
        Collections.sort(points);

        int count = 0, answer = 0;
        for (Point point : points) {
            if (point.isStart) {
                count++;
            } else {
                count--;
            }
            answer = Math.max(answer, count);
        }

        System.out.print(answer);
    }

    private static class Point implements Comparable<Point> {
        private int coord;
        private boolean isStart;

        public Point(int coord, boolean isStart) {
            this.coord = coord;
            this.isStart = isStart;
        }

        @Override
        public int compareTo(Point o) {
            if (this.coord == o.coord) {
                return Boolean.compare(this.isStart, o.isStart);
            }
            return Integer.compare(this.coord, o.coord);
        }
    }
}