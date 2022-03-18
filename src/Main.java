import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static class Person {
        int index, priority;
        public Person(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer in_options = new StringTokenizer(br.readLine(), " ");
        StringTokenizer in_nums = new StringTokenizer(br.readLine(), " ");
        Queue<Person> queue = new LinkedList<>();

        int N = Integer.parseInt(in_options.nextToken());
        int M = Integer.parseInt(in_options.nextToken());
        int answer = 0;
        for(int i = 0; i < N; i++)
            queue.offer(new Person(i, Integer.parseInt(in_nums.nextToken())));

        while(!queue.isEmpty()) {
            Person target = queue.poll();
            for(Person x : queue) {
                if(x.priority > target.priority) {
                    queue.offer(target);
                    target = null;
                    break;
                }
            }
            if(target != null) {
                answer++;
                if(target.index == M) break; // 루프 종료 조건
            }
        }
        System.out.println(answer);
    }
}