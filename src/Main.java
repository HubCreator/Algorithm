import java.util.LinkedList;
import java.util.Queue;

class Person {
    int id, priority;

    public Person(int id, int priority) {
        this.id = id;
        this.priority = priority;
    }
}

public class Main {
    private int solution(int n, int m, int[] arr) {
        Queue<Person> queue = new LinkedList<>();
        int cnt = 0;
        for (int i = 0; i < n; i++) queue.offer(new Person(i, arr[i]));

        while (!queue.isEmpty()) {
            Person poll = queue.poll();
            for (Person x : queue) {
                if (poll.priority < x.priority) {
                    queue.offer(poll);
                    poll = null;
                    break;
                }
            }
            if (poll != null) {
                cnt++;
                if (poll.id == m) return cnt;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Main T = new Main();
        int n = 6;
        int m = 3;
        int[] arr = {70, 60, 90, 60, 60, 60};

        System.out.println(T.solution(n, m, arr));
    }
}