import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int test_case = 1; test_case <= T; test_case++) {
            answer.append("#").append(test_case).append(" ");

            int length = Integer.parseInt(br.readLine());
            int[] arr = new int[length];
            long sum = 0;
            int max = 0;

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < length; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = length - 1; i >= 0; i--) {
                if (max < arr[i]) max = arr[i]; // max 갱신
                else sum += max - arr[i]; // max가 아니면 차이만큼 sum에 더함
            }
            answer.append(sum).append("\n");
        }
        System.out.println(answer);
    }
}