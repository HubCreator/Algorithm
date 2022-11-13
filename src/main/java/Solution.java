import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static StringBuilder answer = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int test_case = 1; test_case <= 10; test_case++) {
            answer.append("#").append(test_case).append(" ");
            LinkedList<Integer> dQueue = new LinkedList<>();

            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int len = st.countTokens();
            for (int i = 0; i < len; i++) {
                dQueue.offer(Integer.parseInt(st.nextToken()));
            }
            for (int i = 0; i < n; i++) {
                Collections.sort(dQueue);
                if (dQueue.getFirst().equals(dQueue.getLast())) break; // 평탄화 완료
                dQueue.offerLast(dQueue.pollLast() - 1);
                dQueue.offerFirst(dQueue.pollFirst() + 1);
            }
            Collections.sort(dQueue);
            answer.append(dQueue.getLast() - dQueue.getFirst()).append("\n");
        }
        System.out.println(answer);
    }
}