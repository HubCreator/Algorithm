import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private boolean solution(String t, String plan) {
        Queue<Character> queue = new LinkedList<>();
        for (char c : t.toCharArray()) queue.offer(c);
        for (char x : plan.toCharArray()) {
            if (queue.contains(x) ) {
                if(queue.peek() == x)
                    queue.poll();
                else return false;
            }
        }
        return queue.size() == 0;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String t = br.readLine();
        String plan = br.readLine();
        System.out.println(T.solution(t, plan) ? "YES" : "NO");
    }
}