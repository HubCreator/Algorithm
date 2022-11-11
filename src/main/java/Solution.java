import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String num = st.nextToken();
            int cnt = Integer.parseInt(st.nextToken());
            answer.append("#").append(i + 1).append(" ").append(solution(new StringBuilder(num), cnt)).append("\n");
        }
        System.out.println(answer);
    }

    private static int solution(StringBuilder num, int cnt) {
        int idx = 0;
        PriorityQueue<Character> pQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < num.length(); i++) {
            pQueue.offer(num.charAt(i));
        }
        for (int i = 0; i < cnt; i++) {
            Character poll = pQueue.poll();
            int targetIdx = num.lastIndexOf(String.valueOf(poll));
            while (Integer.parseInt(String.valueOf(num.charAt(idx))) > poll) {
                idx++;
            }
            char tmp = num.charAt(idx);
            num.replace(idx, idx + 1, String.valueOf(num.charAt(targetIdx)));
            num.replace(targetIdx, targetIdx + 1, String.valueOf(tmp));
            idx = (idx + 1) % num.length();
        }
        return Integer.parseInt(num.toString());
    }
}