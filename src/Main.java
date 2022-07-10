import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Person implements Comparable<Person> {
    int h, w;

    public Person(int h, int w) {
        this.h = h;
        this.w = w;
    }

    @Override
    public int compareTo(Person o) {
        if (o.h == this.h) return o.w - this.w;
        else return o.h - this.h;
    }
}

public class Main {
    private int solution(ArrayList<Person> list) {
        int answer = 0, max = Integer.MIN_VALUE;
        Collections.sort(list);
        for (Person p : list) {
            if (p.w > max) {
                max = p.w;
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Person> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer tmp = new StringTokenizer(br.readLine(), " ");
            int h = Integer.parseInt(tmp.nextToken());
            int w = Integer.parseInt(tmp.nextToken());
            list.add(new Person(h, w));
        }
        System.out.println(T.solution(list));
    }
}