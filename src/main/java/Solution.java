import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] entry = {2, 3, 5, 7, 11};

        for (int i = 0; i < n; i++) {
            answer.append("#").append(i + 1).append(" ");
            long num = Long.parseLong(br.readLine());
            for (int e : entry) {
                int cnt = 0;
                long target = num;
                while (target % e == 0) {
                    target /= e;
                    cnt++;
                }
                answer.append(cnt).append(" ");
            }
            answer.append("\n");
        }
        System.out.println(answer);
    }
}