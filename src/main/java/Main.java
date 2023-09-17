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
        int t = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            List<Person> people = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                people.add(new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }
            Collections.sort(people);
            int target = people.get(0).interview;
            for (int j = 1; j < people.size(); j++) {
                if (target < people.get(j).interview) {
                    n -= 1;
                    continue;
                }
                target = people.get(j).interview;
            }
            answer.append(n).append('\n');
        }
        System.out.print(answer);
    }

    public static class Person implements Comparable<Person>{
        private int paper, interview;

        public Person(int paper, int interview) {
            this.paper = paper;
            this.interview = interview;
        }

        @Override
        public int compareTo(Person o) {
            if (this.paper == o.paper) {
                return Integer.compare(this.interview, o.interview);
            }
            return Integer.compare(this.paper, o.paper);
        }
    }
}
