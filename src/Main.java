import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fixed = br.readLine();
        String planned = br.readLine();
        Queue<Character> queue = new LinkedList<>();
        boolean answer = true;

        for(char x : fixed.toCharArray())
            queue.offer(x);

        for(char x : planned.toCharArray()) {
            if(queue.contains(x)) {
                if (queue.poll() != x) { // 참이든 아니든 poll이 실행됨
                    answer = false;
                    break;
                }
                // else queue.poll(); // 필요 없음
            }
        }
        // 선수과목을 모두 듣지 않아도 false
        if(!queue.isEmpty()) answer = false;
        System.out.println(answer ? "YES" : "NO");
    }
}