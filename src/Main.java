import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

// LRU 구현
public class Main {
    private Deque<Integer> solution(int s, int n, int[] arr) {
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (deque.size() < s) {
                if (!deque.contains(arr[i]))
                    deque.offerFirst(arr[i]);
                else {
                    if (deque.remove(arr[i])) deque.offerFirst(arr[i]);
                }
            } else {
                if (!deque.contains(arr[i])) {
                    deque.pollLast();
                    deque.offerFirst(arr[i]);
                } else {
                    if (deque.remove(arr[i])) deque.offerFirst(arr[i]);
                }
            }
        }
        return deque;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        int s = Integer.parseInt(st1.nextToken());
        int n = Integer.parseInt(st1.nextToken());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }
        for (Integer x : T.solution(s, n, arr)) {
            System.out.print(x + " ");
        };
    }
}