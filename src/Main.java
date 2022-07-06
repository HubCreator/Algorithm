import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private List<Integer> solution(int s, int n, int[] arr) {
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < s; i++) deque.offerFirst(arr[i]); // 초기값 설정
        for (int i = s; i < n; i++) {
            int t = arr[i];
            if (deque.contains(t)) {
                deque.remove(t);
                deque.offerFirst(t);
            } else {
                deque.pollLast();
                deque.offerFirst(t);
            }
        }

        return new ArrayList<>(deque);
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringTokenizer tmp = new StringTokenizer(br.readLine(), " ");
        int s = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(tmp.nextToken());
        for (Integer x : T.solution(s, n, arr)) System.out.print(x + " ");
    }
}