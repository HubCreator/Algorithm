import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Person {
    int id, priority;

    public Person(int id, int priority) {
        this.id = id;
        this.priority = priority;
    }
}
public class Main {
    private int solution(int m, int[] arr) {
        Queue<Person> queue = new LinkedList<>();
        int answer = 0;
        for (int i = 0; i < arr.length; i++) queue.offer(new Person(i, arr[i]));
        while (!queue.isEmpty()) {
            Person p = queue.poll();
            for (Person x : queue) {
                if (x.priority > p.priority) {
                    queue.offer(p);
                    p = null;
                    break;
                }
            }
            if (p != null) {
                answer++;
                if(p.id == m) return answer;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        StringTokenizer tmp = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(tmp.nextToken());
        System.out.println(T.solution(m, arr));
    }
}