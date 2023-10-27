import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Student> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            queue.add(new Student(st.nextToken(), Integer.parseInt(st.nextToken())));
        }

        while (queue.size() > 1) {
            Student poll = queue.poll();
            for (int i = 0; i < poll.num - 1; i++) {
                queue.offer(queue.poll());
            }
            queue.poll();
        }

        System.out.print(queue.poll().name);
    }

    public static class Student {
        private String name;
        private int num;

        public Student(String name, int num) {
            this.name = name;
            this.num = num;
        }
    }
}
