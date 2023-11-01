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
        List<Racer> racers = new ArrayList<>();
        int[] score = new int[]{10, 8, 6, 5, 4, 3, 2, 1, 0};
        for (int i = 0; i < 8; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String lap = st.nextToken();
            String team = st.nextToken();
            String[] split = lap.split(":");
            racers.add(new Racer(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), team));
        }
        Collections.sort(racers);

        int r = 0, b = 0;
        for (int i = 0; i < racers.size(); i++) {
            if (racers.get(i).team.equals("R")) {
                r += score[i];
            } else {
                b += score[i];
            }
        }

        if (r < b) {
            System.out.println("Blue");
            return;
        }
        System.out.println("Red");
    }

    private static class Racer implements Comparable<Racer> {
        private int M, SS, ss;
        private String team;

        public Racer(int M, int SS, int ss, String team) {
            this.M = M;
            this.SS = SS;
            this.ss = ss;
            this.team = team;
        }

        @Override
        public int compareTo(Racer o) {
            if (this.M == o.M) {
                if (this.SS == o.SS) {
                    return Integer.compare(this.ss, o.ss);
                }
                return Integer.compare(this.SS, o.SS);
            }
            return Integer.compare(this.M, o.M);
        }
    }
}