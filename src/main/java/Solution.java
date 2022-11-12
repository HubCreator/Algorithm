import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static StringTokenizer st;
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            int test = Integer.parseInt(br.readLine());
            int max = Integer.MIN_VALUE;
            int arr[] = new int[101];

            answer.append("#").append(test).append(" ");
            st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens()) {
                arr[Integer.parseInt(st.nextToken())]++;
            }
            for (int data : arr) {
                max = Math.max(max, data);
            }
            for (int i = arr.length - 1; i >= 0; i--) {
                if (arr[i] == max) {
                    answer.append(i).append("\n");
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}