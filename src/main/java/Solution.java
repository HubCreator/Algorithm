import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        StringTokenizer st;
        List<Integer> list, window;
        int length, result;

        for (int i = 0; i < 10; i++) {
            answer.append("#").append(i + 1).append(" ");
            list = new ArrayList<>();
            window = new ArrayList<>();
            length = Integer.parseInt(br.readLine());
            result = 0;

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < length; j++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            // 초기 윈도우값 설정
            for (int j = 0; j < 4; j++) {
                window.add(list.get(j));
            }

            for (int j = 4; j < list.size(); j++) {
                window.add(list.get(j));
                PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());
                pQueue.addAll(window);
                Integer target = window.get(2);
                Integer poll = pQueue.poll();
                if (poll.equals(target) && poll > pQueue.peek()) {
                    result += poll - pQueue.peek();
                }
                window.remove(0);
            }
            answer.append(result).append("\n");
        }
        System.out.println(answer);
    }
}