import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < T; i++) {
            answer.append("#").append(i + 1).append(" ");
            int n = Integer.parseInt(br.readLine());
            answer.append(n % 2 == 0 ? "Alice" : "Bob").append("\n");
        }
        System.out.println(answer);
    }
}