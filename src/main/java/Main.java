import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            people.add(new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i));
        }
        Collections.sort(people);

        for (int i = 0; i < people.size(); i++) {
            people.get(i).prize = solution(people, i);
        }

        Collections.sort(people, Comparator.comparingInt(a -> a.index));
        for (Person person : people) {
            answer.append(person.prize).append(' ');
        }

        System.out.print(answer);
    }

    private static int solution(List<Person> people, int num) {
        int count = 0;
        for (int i = 0; i < num; i++) {
            if (people.get(i).y > people.get(num).y) {
                count++;
            }
        }
        return count + 1;
    }

    private static class Person implements Comparable<Person> {
        int x, y, index, prize;

        public Person(int x, int y, int index) {
            this.x = x;
            this.y = y;
            this.index = index;
        }

        @Override
        public int compareTo(Person o) {
            if (x == o.x) {
                return Integer.compare(o.y, y);
            }
            return Integer.compare(o.x, x);
        }
    }
}
